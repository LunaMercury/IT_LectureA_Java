// 클릭 이벤트 처리

package Ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C06GUI extends JFrame implements ActionListener {
	// 버튼을 멤버변수로 설정
	JButton btn1 = new JButton("파일로 저장");
	JButton btn2 = new JButton("1:1 요청");
	JButton btn3;
	JButton input;

	public C06GUI(String title) {
		// Frame
		super(title);
		setBounds(100, 100, 400, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 10, 200, 250);
		btn1 = new JButton("파일로 저장");
		btn1.setBounds(220, 10, 150, 40);
		btn2 = new JButton("1:1 요청");
		btn2.setBounds(220, 70, 150, 40);
		btn3 = new JButton("대화기록보기");
		btn3.setBounds(220, 130, 150, 40);
		JTextField txt1 = new JTextField();
		txt1.setBounds(10, 300, 200, 40);
		input = new JButton("입력");
		input.setBounds(220, 300, 150, 40);

		// Event Listner add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);

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
			System.out.println("파일로 저장");
		} else if (e.getSource() == btn2) {
			System.out.println("1:1 요청 클릭");
		} else if (e.getSource() == btn3) {
			System.out.println("대화기록보기");
		}
		if (e.getSource() == input) {
			System.out.println("입력");
		}
	}

}

public class C06SwingEventMain {

	public static void main(String[] args) {

		new C06GUI("Chatting Server");

	}

}
