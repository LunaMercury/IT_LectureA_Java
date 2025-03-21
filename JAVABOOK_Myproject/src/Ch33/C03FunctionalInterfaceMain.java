package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import net.bytebuddy.asm.Advice.Return;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.

//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class C03FunctionalInterfaceMain {

	// 01
	public static Function<Integer, Integer> func1 = (args) -> args * args;
	// 02
	public static Function<Integer, Integer> func2 = (args) -> args + args;
	// 03
	public static Function<List<Integer>, Integer> func3 = (list) -> list.stream().reduce(0, (a, b) -> a + b);

	// 04
	public static Function<List<Object>, Integer> func4 = (list) -> list.stream().filter(obj -> obj instanceof Integer)
			.map(obj -> (Integer) obj).reduce(0, (a, b) -> a + b);

	// 05
	public static Function<List<Object>, List<Integer>> func5 = (li) -> li.stream()
			.filter(obj -> obj instanceof Integer).map(obj -> (Integer) obj).collect(Collectors.toList());

	// 06
	// 함수간 연결. 여기서는 func1은 더하기, func2는 곱하기였으므로 arg1*arg1=arg2, arg2+arg2 를 한다.
	public static Function<Integer, Integer> func6 = func1.andThen(func2);
	// 07. 위와 반대로
	public static Function<Integer, Integer> func7 = func2.andThen(func1);

	// ??. 8번 함수를 실행시키려면 이게 먼저 있어야 한다고 함. 객체지향 특성이 아닌 순서대로 초기화된다고 함.
	public static Function<List<Integer>, List<Object>> funtrans = (li) -> li.stream().map(obj -> (Object) obj)
			.collect(Collectors.toList());

	// 08
	public static Function<List<Object>, Integer> func8 = func5.andThen(funtrans).andThen(func4);

	// 09
	public static Function<Integer, Function<Integer, Integer>> func9 = (x) -> {
		return (y) -> {
			return x + y;
		};
	};

	// 10
	public static Function<Integer, Function<Integer, Integer>> func10 = x -> y -> x + y;
	// 11
	public static Function<Integer, Function<Integer, Function<Integer, Integer>>> func11 = a -> b -> c -> a + b + c;	

	public static void main(String[] args) {
		System.out.println(func1.apply(11));
		System.out.println(func2.apply(11));
		System.out.println(func3.apply(Arrays.asList(11, 22, 33, 44)));
		System.out.println(func4.apply(Arrays.asList(11, 'A', 33, 44, true, 'A', '2')));
		System.out.println(func5.apply(Arrays.asList(11, 'A', 33, 44, true, 'A', '2')));
		System.out.println(func6.apply(5));
		System.out.println(func7.apply(5));
		System.out.println(func9.apply(5).apply(10));
		System.out.println(func11.apply(5).apply(10).apply(15));

	}
}