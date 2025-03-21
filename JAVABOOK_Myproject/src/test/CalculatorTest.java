package test;

@FunctionalInterface
interface Calculator {
	int calculate(int a, int b);
}

public class CalculatorTest {
	public static void main(String[] args) {
		// 덧셈
		Calculator addition = (num1, num2) -> num1 + num2;

		// 뺄셈
		Calculator subtraction = (num1, num2) -> num1 > num2 ? num1 - num2 : num2 - num1;

		// 곱셈
		Calculator multiplication = (num1, num2) -> num1 * num2;

		// 나눗셈
		Calculator division = (num1, num2) -> num1 / num2;

		System.out.println("덧셈: " + addition.calculate(10, 5));
		System.out.println("뺄셈: " + subtraction.calculate(10, 5));
		System.out.println("곱셈: " + multiplication.calculate(10, 5));
		System.out.println("나눗셈: " + division.calculate(10, 5));
	}
}