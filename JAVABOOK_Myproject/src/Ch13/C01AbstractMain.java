package Ch13;

// 일반 클래스 상속관계
class Super1{
	void func() {};
};

class Sub1 extends Super1{
	void func() {
		System.out.println("Overrided sub1.func() call");
	}
};

// 추상 클래스 상속관계 : abstract
abstract class Super2{ // 클래스가 추상임을 선언하기 위한 abstract
	abstract void func(); // 메서드가 추상임을 선언하기 위한 abstract

};

class Sub2 extends Super2{	
	// 추상클래스 Super2를 상속받았으므로 반드시 이 추상클래스의 메서드를 완성시켜야 한다.
	@Override
	void func() {
		System.out.println("Overrided sub2.func() call");
		
	}	
}


public class C01AbstractMain {

	public static void main(String[] args) {
		
		// 01
		Super1 ob1 = new Super1();	// 상위클래스형으로 객체생성 가능
		Sub1 ob2 = new Sub1();		// 하위클래스형으로 객체생성 가능
		Super1 ob3 = new Sub1();	// Upcasting 가능
		ob3.func();					// 재정의된 함수 접근 가능
		
		// 02
//		Super2 ob4 = new Super2();	// 상위클래스형으로 객체생성 불가
		Sub2 ob5 = new Sub2();		// 하위클래스형으로 객체생성 가능(미완성된 함수를 완성하는 것이 전제)
		Super2 ob6 = new Sub2();	// Upcasting 가능
		ob6.func();					// 재정의된 함수 접근 가능
		
	}

}
