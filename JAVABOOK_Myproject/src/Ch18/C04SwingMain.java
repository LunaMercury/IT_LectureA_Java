// 버튼 및 텍스트 입력구간

package Ch18;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 클래스로 만들어서 관리하는 것이 편하다.
class C04GUI extends JFrame {

	public C04GUI(String title) {
		// Frame
		super(title);
		setBounds(100, 100, 300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// Panel
		JPanel panel = new JPanel();
//		Color col = new Color(71, 144, 0);
//		panel.setBackground(col);
		panel.setLayout(null); // 이게 있어야 panel에서의 위치를 조절할 수 있다. 없으면 디폴트로 일자 중앙정렬이다.

		// Component
		JButton btn1 = new JButton("BTN01");
		btn1.setBounds(10, 10, 100, 30);
		JButton btn2 = new JButton("BTN02");
		btn2.setBounds(120, 10, 100, 30);
		// 입력구간
		JTextField txt1 = new JTextField();
		txt1.setBounds(10, 50, 210, 30);
		// 입력구간. 테두리 없음
		JTextArea area1 = new JTextArea("여기에 입력 가능");
//		area1.setBounds(10, 90, 210, 310); //아래 scroll로 인해 필요없다.
		// 스크롤
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 90, 210, 310);

		// Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
//		panel.add(area1);//아래 scroll1이 있어 필요없다.
		panel.add(scroll1);

		// Frame에 Panel 넣기
		add(panel);
		
		
		setVisible(true);
	}

}

public class C04SwingMain {

	public static void main(String[] args) {
		new C04GUI("네 번째 프레임입니다");
	}
}