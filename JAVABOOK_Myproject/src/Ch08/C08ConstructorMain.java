package Ch08;

// 생성자 메서드
// 객체 생성시 한번만 호출되는 메서드
// 생성된 객체 내에서는 사용이 불가능
// 객체 생성시에 필요한 메모리공간 형성과 "초기값 부여"에 사용
// 생성자 메서드 이름은 클래스 이름과 동일하며, 반환자료형은 가지지 않는다.

// 생성자 함수를 클래스 내에 명시하지 않으면 컴파일러에 의해 주입되는 생성자가 존재. 이를 디폴트 생성자라 한다. 

class C08Simple {
	// 속성
	int n1;
	double n2;
	boolean n3;
	String n4;

	// 아래는 생성자 메서드. 클래스 이름과 동일해야 한다.
	C08Simple() {
		System.out.println("C08Simple() 생성자 호출 - 디폴드 생성자");
	}

	C08Simple(int n1) {
		System.out.println("C08Simple(int n1) 생성자 호출");
		this.n1 = n1;
	}

	C08Simple(int n1, double n2) {
		System.out.println("C08Simple(int n1, double n2) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
	}

	C08Simple(int n1, double n2, boolean n3) {
		System.out.println("C08Simple(int n1, double n2, boolean n3) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	C08Simple(int n1, double n2, boolean n3, String n4) {
		System.out.println("C08Simple(int n1, double n2, boolean n3, String n4) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}

	// 아래는 constructor 생성기로 만든 초기값생성자
//	public C08Simple(int n1, double n2, boolean n3, String n4) {
//	super();
//	this.n1 = n1;
//	this.n2 = n2;
//	this.n3 = n3;
//	this.n4 = n4;
//}

	// toString 재정의
	@Override
	public String toString() {
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}

}

public class C08ConstructorMain {

	public static void main(String[] args) {
		C08Simple obj0 = new C08Simple();
		C08Simple obj1 = new C08Simple(10);
		C08Simple obj2 = new C08Simple(10, 10.5);
		C08Simple obj3 = new C08Simple(10, 10.5, true);
		C08Simple obj4 = new C08Simple(10, 10.5, true, "홍길동");

		System.out.println(obj0);
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);
	}
}