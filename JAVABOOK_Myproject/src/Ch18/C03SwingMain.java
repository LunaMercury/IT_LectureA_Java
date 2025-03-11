package Ch18;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 클래스로 만들어서 관리하는 것이 편하다.
class C03GUI extends JFrame {

	public C03GUI(String title) {
		// Frame
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Panel
		JPanel panel = new JPanel();
		Color col = new Color(71, 144, 0);
		panel.setBackground(col);

		// Frame(Panel)
		add(panel);
	}

}

public class C03SwingMain {

	public static void main(String[] args) {
		new C03GUI("세 번째 프레임입니다");
	}
}