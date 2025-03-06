package Ch11;

class C02Simple {
	static int n1;
	int n2;

	void func1() {
		n1 = 100;
		n2 = 200;
	}

	static void func2() {
		n1 = 100;
//		n2 = 200; // 안되는 이유는 func2()가 객체 생성과 무관하게 먼저 만들어지기 때문이다. 생성순서가 static 인 n1, static인 func2()가 먼저 만들어지고 다음 n2, func1()이 만들어지기 때문에 만들어지지도 않은 n2를 참조할 수 없기 때문이다.
	}
}

public class C02StaticMain {

	public static void main(String[] args) {

	}

}
