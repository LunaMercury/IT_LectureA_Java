// throw는 예외를 생성할 때
// throws는 예외를 던질 때

package Ch15;

class A {
	public void Ex1() throws NullPointerException {
		System.out.println("Ex1 processing 1");
		throw new NullPointerException("Ex1 NULL Exception"); // 예외를 직접 만듬(테스트용)
	}
}

class B {
	public void Ex2() throws NullPointerException {
		System.out.println("Ex2 processing 1");
		throw new NullPointerException("Ex2 NULL Exception");
	}
}

public class C05ThrowAndThrowsMain {

	public static void main(String[] args) {
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		A a = new A();
		B b = new B();

		try {
			a.Ex1();
			b.Ex2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("실행코드3");

	}

}
