package Ch18;

import javax.swing.JFrame;

public class C01SwingMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("첫 번째 프레임입니다");
		frame.setBounds(100, 100, 500, 500);// 화면크기. x, y, width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 이거 없으면 X버튼 눌러도 백그라운드에서 계속 작동한다.
		frame.setVisible(true);
	}
}