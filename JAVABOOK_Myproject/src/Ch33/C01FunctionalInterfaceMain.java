package Ch33;

// @FunctionalInterface 를 작성함으로서 이 추상클래스가 함수형 인터페이스임을 알린다.
// 이를 통해 원래 다양한 메서드만 가질 수 있었던 것을 하나로 제한할 수 있다.
@FunctionalInterface
interface Func1 {
	void say(String message);
}

public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {
		// 01
		Func1 func1 = (message) -> {
			System.out.println(message);
		};
		func1.say("HELLO WORLD");

		Func1 func1_1 = System.out::println;
		func1_1.say("HELLO WORLD");
	}
}