package Ch09;

// this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보(메모리 주소 - 해시코드값)을 확인하는데 사용

// this : 멤버변수와 지역변수 구별에 사용
// this : 다른 생성자 호출에 사용

class C03Simple {
	int x;
	int y;

	// 생성자
	public C03Simple() {
		this(0,0);
		System.out.println("C03Simple() 생성자 호출");
	}

	public C03Simple(int x) {
		this(x,0);
		System.out.println("C03Simple(int x) 생성자 호출");
		this.x = x;
	}

	public C03Simple(int x, int y) {
		System.out.println("C03Simple(int x, int y) 생성자 호출");
		this.x = x;
		this.y = y;
	}

	C03Simple getThis() {
		return this;
	}

}

public class C03This {

	public static void main(String[] args) {

		C03Simple ob = new C03Simple();
		System.out.println(ob);
		System.out.println(ob.getThis());
	}
}