package Ch12;

class C08Super {
	void func1() {
		System.out.println("C08.Super.func1() Call");
	}
//	void func2() {System.out.println("asdf");} // 이게 있으면 Downcating 필요
}

class C08Sub extends C08Super {
	void func2() {
		System.out.println("C08.Sub.func2() Call");
	}
}

public class Ch08UpDownCastingMain {

	public static void main(String[] args) {
		C08Super ob1 = new C08Super();
		ob1.func1();

		System.out.println("------------------------");
		C08Sub ob2 = new C08Sub();
		ob2.func1();
		ob2.func2();

		System.out.println("------------------------");
		C08Super ob3 = new C08Sub(); // Upcasting
		ob3.func1();
		C08Sub subb = (C08Sub) ob3; // C08Super의 주석처리된 func2()가 있다면 함수재정의 할 수 있으므로 이 코드는 필요없고, 바로 ob3.func2(); 를 작성할 수 있다.
		subb.func2();
		
		// Upcasting 상태에서
		// 확장된 멤버변수 접근 불가 -> Downcasting 필요
		// 확장된 멤버함수 접근 불가 -> Downcasting 필요
		// 재정의된 메서드 접근은 가능

	}

}
