package Ch11;

class C01Simple {

	// static : 클래스 내의 멤버에 적용하는 경우 해당 클래스로 객체 생성 시 모든 객체간의 공유되는 멤버로 지정

	static int num1; // static은 먼저 만들어서 method 공간에 저장된다.
	int num2;

	public C01Simple() {
		num1 = 0; // static 이므로 method 공간의 값을 수정
		num2 = 0;
	}

	public C01Simple(int num1, int num2) {
		super();
		this.num1 = num1; // 새로 메모리를 만들어서 저장하지 않고, method 공간의 값을 수정
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "C01Simple [num1=" + num1 + ", num2=" + num2 + "]";
	}

}

public class C01StaticMain {

	public static void main(String[] args) {
		C01Simple.num1 = 5;
		System.out.println(C01Simple.num1);

		C01Simple ob1 = new C01Simple(10, 20);
		C01Simple ob2 = new C01Simple(30, 40);

		System.out.println(ob1);
		System.out.println(ob2);

	}
}