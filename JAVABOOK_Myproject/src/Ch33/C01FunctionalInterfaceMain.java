package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// @FunctionalInterface 를 작성함으로서 이 추상클래스가 함수형 인터페이스임을 알린다.
// 이를 통해 원래 다양한 메서드만 가질 수 있었던 것을 하나로 제한할 수 있다.
@FunctionalInterface
interface Func1 {
	void say(String message);
}

interface Func2 {
	int sum(int... num);
}

interface Func3 {
	List<Integer> createListDesc(int... args);
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

		// 02
		// func2
		Func2 func2 = (items) -> {
			int sumAll = 0;
			for (int item : items) {
				sumAll += item;
			}
			return sumAll;
		};
		System.out.println(func2.sum(10, 20, 30, 40, 556, 6, 7, 8, 9));

		Func2 func2_2 = (items) -> {
			// {}에 모든 items을 더한 값을 리턴(reduce)
			return Arrays.stream(items).reduce(0, (sum, el) -> sum + el);
		};
		System.out.println(func2_2.sum(10, 20, 30, 40, 556, 6, 7, 8, 9));

		// 03
		// 원시타입 int[] 받기 -> int를 Integer로 boxing -> 내림차순 -> List<Integer>
		Func3 func3 = (items) -> {
			return Arrays.stream(items).boxed().sorted((a, b) -> a - b).collect(Collectors.toList());
		};
		System.out.println(func3.createListDesc(10, 200, 30, 40, 50, 55, 12));
	}
}