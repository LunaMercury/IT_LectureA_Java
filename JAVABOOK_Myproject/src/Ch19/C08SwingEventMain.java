// 아래 빈칸 입력 후 엔터시 위에 올라감
// 입력 클릭도 동일
// 마우스로 area1 클릭 시 마우스 위치, 줄번호, 내용 등을 콘솔에

// 저장기능, 불러오기 기능

package Ch19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C07GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	// 버튼을 멤버변수로 설정
	JTextArea area1;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	JTextField txt1;
	Writer out;

	public void setInput() {
		String message = txt1.getText();
		System.out.println(message);
		area1.append(message + "\n");
		txt1.setText("");
	}

	public C07GUI(String title) {
		// Frame
		super(title);
		setBounds(100, 100, 400, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component
		area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 10, 200, 250);
		btn1 = new JButton("저장하기");
		btn1.setBounds(220, 10, 150, 40);
		btn2 = new JButton("불러오기");
		btn2.setBounds(220, 70, 150, 40);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(220, 130, 150, 40);
		txt1 = new JTextField();
		txt1.setBounds(10, 300, 200, 40);
		input = new JButton("입력");
		input.setBounds(220, 300, 150, 40);

		// Event Listner add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		// Panel(Component)
		panel.add(scroll1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(input);

		add(panel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
			fileChooser.setDialogTitle("불러올 파일을 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			File defaultDirPath = new File("C:\\IOTEST");
			if (defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);
			
			
			
			
			
		} else if (e.getSource() == btn3) {
			System.out.println("대화기록보기");
		}
		if (e.getSource() == input) {
			System.out.println("입력 클릭");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("pressed" + e.getKeyChar());
//		System.out.println("pressed" + e.getKeyCode());
		if (e.getSource() == txt1) {
			if (e.getKeyCode() == 10) {
				setInput();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("released");		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			System.out.println("mouse clicked :" + e.getPoint()); // 마우스 클릭한 위치 확인
			int offset = area1.viewToModel(e.getPoint()); // 상대위치 확인
			System.out.println("offset :" + offset);
			// 행의 위치 확인
			int row = area1.getLineOfOffset(offset);
			System.out.println("row : " + row);
			// 글자 길이에 따라 달라지는 변수. 한 줄의 글자가 늘어날 때마나 endoffset은 증가한다.
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
			System.out.printf("%d %d\n", startOffset, endOffset);
			String str = area1.getText(startOffset, endOffset - startOffset);
			System.out.println("str : " + str);

		} catch (BadLocationException e1) {
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

public class C08SwingEventMain {

	public static void main(String[] args) {

		new C07GUI("Chatting Server");

	}

}
