package Ch33;

import java.util.Arrays;

@FunctionalInterface
interface Functional {
	Integer execute(int... args);
}

class Calc {
	// 각각 람다&스트림 함수를 적절히 이용해서 기능 구현
	// 모든 인자를 받을 수 있는 가변인자 처리로 구현
	// 뺄셈, 나눗셈은 큰수에 작은수로 정렬(sorted) 후 누적 감산 처리(reduce)

	Functional sum;
	Functional sub;
	Functional mul;
	Functional div;

	public Calc() {
		sum = (args) -> Arrays.stream(args).reduce(0, (summ, el) -> summ + el);
		sub = (args) -> Arrays.stream(args).boxed().sorted((a, b) -> b - a).reduce(0,
				(sub, el) -> sub < el ? el - sub : sub - el);
		mul = (args) -> Arrays.stream(args).reduce(1, (a, b) -> a * b);
	}

}

public class C02Ex {

	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("합 : " + calc.sum.execute(10, 20, 30, 40, 50, 60));
		System.out.println("차 : " + calc.sub.execute(1, 4, 2, 9));
		System.out.println("곱 : " + calc.mul.execute(10, 20, 30, 40, 50, 60));
//		System.out.println("분 : " + calc.sum.execute(10, 20, 30, 40, 50, 60));
	}
}