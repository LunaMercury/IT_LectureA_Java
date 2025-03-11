package Ch18;

import javax.swing.JFrame;

// 클래스로 만들어서 관리하는 것이 편하다.
class C02GUI extends JFrame{
	public C02GUI(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}

public class C02SwingMain {

	public static void main(String[] args) {
		new C02GUI("두 번째 프레임입니다");
	}
}