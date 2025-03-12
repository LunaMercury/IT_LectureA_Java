package Ch18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends JFrame {

	public GUI(String title) {
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
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(220, 10, 150, 40);
		JButton btn2 = new JButton("1:1 요청");
		btn2.setBounds(220, 70, 150, 40);
		JButton btn3 = new JButton("대화기록보기");
		btn3.setBounds(220, 130, 150, 40);
		JTextField txt1 = new JTextField();
		txt1.setBounds(10, 300, 200, 40);
		JButton input = new JButton("입력");
		input.setBounds(220, 300, 150, 40);

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

}

public class C05Ex {

	public static void main(String[] args) {

		// Component 참조변수명
		// textarea = area1
		// textarea's scroll = scroll1
		// 파일로저장 : btn1
		// 1:1요청 : btn2
		// 대화기록보기 : btn3
		// 입력 : input
		// textfield : txt1

		new GUI("Chatting Server");

	}

}
