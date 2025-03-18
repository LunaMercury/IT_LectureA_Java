// swing과 데이터베이스 접목

package Ch21;

import java.awt.JobAttributes.DefaultSelectionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import org.slf4j.jul.JULServiceProvider;

class Memo {
	private int id;
	private String text;
	private LocalDateTime createAt;

	// toString
	@Override
	public String toString() {
		return "Memo [id=" + id + ", text=" + text + ", createAt=" + createAt + "]";
	}

	// getter, setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	// Constructor
	public Memo() {
	}

	public Memo(int id, String text, LocalDateTime createAt) {
		super();
		this.id = id;
		this.text = text;
		this.createAt = createAt;
	}

}

class SelectFrame extends JFrame implements MouseListener, ActionListener {

	C07GUI mainUI;
	JTable table;
	JScrollPane scroll;
	JPanel panel;
	JButton selectButton;
	String selectedText;

	SelectFrame(C07GUI mainUI) {
		super("SELECT 결과");
		this.mainUI = mainUI;

		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// EXIT_ON_CLOSE 이거 하면 창이 다 닫힌다.

		// panel
		panel = new JPanel();
		panel.setLayout(null);

		// 버튼
		selectButton = new JButton("선택");
		selectButton.setBounds(410, 10, 70, 30);
		selectButton.addActionListener(this);

		// frame(panel)
		add(panel);
		panel.add(selectButton);

		// event
		setVisible(false);
	}

	void select(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (scroll != null) {
			panel.remove(scroll);
		}

		try {
			// SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_memo");

			// SQL 실행
			Memo memo;
			List<Memo> list = new ArrayList();
			rs = pstmt.executeQuery();

			// component
			String[] column = { "ID", "TEXT", "CREATED_AT" };
			List<String[]> data = new ArrayList();

			// memo에 하나씩 넣는 작업
			if (rs != null) {
				while (rs.next()) {
					memo = new Memo();
					memo.setId(rs.getInt("id"));
					memo.setText(rs.getString("text"));
					Timestamp timestamp = rs.getTimestamp("createdAt"); // db에서의 시간포맷과 java의 시간포맷이 다르다
					System.out.print(timestamp);
					memo.setCreateAt(timestamp.toLocalDateTime());
					list.add(memo);

					data.add(new String[] { rs.getString("id"), rs.getString("text"), rs.getString("createdAt") });
				}
			}

			list.forEach(System.out::println);

			String[][] arr = new String[data.size()][];
			// for 값복사
			for (int i = 0; i < data.size(); i++) {
				arr[i] = data.get(i);
			}

			table = new JTable(arr, column);
			scroll = new JScrollPane(table);
			scroll.setBounds(10, 10, 400, 400);

			table.addMouseListener(this);

			// panel(component)
			panel.add(scroll);

		} catch (Exception e2) {
			e2.getStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		int selectedRow = table.getSelectedRow();
		selectedText = table.getValueAt(selectedRow, 1).toString();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectButton) {
			mainUI.area1.setText(selectedText);
		}
	}
}

class C07GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
	JButton btn3; // INSERT
	JButton btn4; // UPDATE
	JButton btn5; // DELETE
	JButton btn6; // SELECT

	JButton input;
	JTextField txt1;
	JTextArea area1;

	Writer out;

	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	SelectFrame selectFrame;

	C07GUI(String title) throws ClassNotFoundException, SQLException {
		// frame
		super(title);
		setBounds(100, 100, 410, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component 참조변수명
		area1 = new JTextArea(); // textarea = area1
		area1.setBounds(10, 10, 260, 280);
		// textarea's scroll = scroll1
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 10, 250, 280);

		btn1 = new JButton("저장하기");
		btn1.setBounds(270, 10, 110, 30);

		btn2 = new JButton("불러오기");// 1:1요청 : btn2
		btn2.setBounds(270, 50, 110, 30);

		btn3 = new JButton("INSERT");// 대화기록보기 : btn3
		btn3.setBounds(270, 90, 110, 30);

		btn4 = new JButton("UPDATE");// 대화기록보기 : btn3
		btn4.setBounds(270, 130, 110, 30);

		btn5 = new JButton("DELETE");// 대화기록보기 : btn3
		btn5.setBounds(270, 170, 110, 30);

		btn6 = new JButton("SELECT");// 대화기록보기 : btn3
		btn6.setBounds(270, 210, 110, 30);

		input = new JButton("입력"); // 입력 : input
		input.setBounds(270, 300, 110, 30);

		txt1 = new JTextField(); // textfield : txt1
		txt1.setBounds(10, 300, 250, 30);

		// event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		// panel(component)
		panel.add(scroll1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(input);
		panel.add(txt1);

		// frame(panel)
		add(panel);

		// frame
		setVisible(true);

		// DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loading Success");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED");

		// selectframe
		selectFrame = new SelectFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		System.out.println("클릭!");
		if (e.getSource() == btn1) {
			System.out.println("저장하기");
			String contents = area1.getText();

			// 파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);

			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : " + selectedVal);

			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);

				// 파일확장자 추가
				String filePath = selectedFile.toString();
				if (!selectedFile.toString().endsWith(".txt")) {
					filePath = selectedFile.toString() + ".txt";
				}
				System.out.println("filePath : " + filePath);

//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//				String filename = LocalDateTime.now().format(formatter);

				try {
					out = new FileWriter(filePath);
					out.write(contents);
					out.flush();
				} catch (Exception e1) {
					e1.printStackTrace();

				} finally {
					try {
						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		} else if (e.getSource() == btn2) {

			System.out.println("불러오기");
			// 파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일을 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);

			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : " + selectedVal);
			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);

				try {

					Reader fin = new FileReader(selectedFile.toString());
					StringBuffer buffer = new StringBuffer();
					while (true) {
						int data = fin.read();
						if (data == -1)
							break;
						buffer.append((char) data);
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		} else if (e.getSource() == btn3) {
			System.out.println("INSERT");
			try {
				pstmt = conn.prepareStatement("insert into tbl_memo values(null,?,now())");
				pstmt.setString(1, area1.getText());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("성공");
					JOptionPane.showMessageDialog(null, "INSERT 성공", "INSERT 확인창", JOptionPane.INFORMATION_MESSAGE);
					;
				} else {
					System.err.println("실패");
					JOptionPane.showMessageDialog(null, "INSERT 실패", "INSERT 확인창", JOptionPane.ERROR_MESSAGE);
					;
				}
			} catch (Exception e2) {
				e2.getStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (Exception e3) {
					e3.getStackTrace();
				}
			}

		} else if (e.getSource() == btn4) {
		} else if (e.getSource() == btn5) {
		} else if (e.getSource() == btn6) {
			System.out.println("SELECT");
			selectFrame.select(conn, pstmt, rs);
			selectFrame.setVisible(true);

		} else if (e.getSource() == input) {
			System.out.println("입력");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());

	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed..."+e.getKeyChar());	
//		System.out.println("keyPressed..."+e.getKeyCode());
		if (e.getSource() == txt1) {
			if (e.getKeyCode() == 10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message + "\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased..."+e.getKeyChar());
//		System.out.println("keyReleased..."+e.getKeyChar());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {

//			System.out.println("mouseClicked..." + e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("mouseClicked...offset : " + offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println("mouseClicked...row : " + row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n", startOffset,endOffset);
			String str = area1.getText(startOffset, endOffset - startOffset);
			System.out.println(str);

		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

public class C07SwingAddDBMain_studying {

	public static void main(String[] args) {

		try {
			new C07GUI("Chatting UI");
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
