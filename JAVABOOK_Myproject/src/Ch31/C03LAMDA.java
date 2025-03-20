package Ch31;

interface Calculator {
	int calculate(int num1, int num2);
}

public class C03LAMDA {

	public static void main(String[] args) {
		// 덧셈
		Calculator add = (num1, num2) -> num1 + num2;

		// 뺄셈
		Calculator sub = (num1, num2) -> num1 > num2 ? num1 - num2 : num2 - num1;
		;
		// 곱셈
		Calculator mul = (num1, num2) -> num1 * num2;

		// 나눗셈
		Calculator div = (num1, num2) -> num1 / num2;

		// 결과
		System.out.println(add.calculate(10, 20));
		System.out.println(sub.calculate(30, 10));
		System.out.println(mul.calculate(10, 20));
		System.out.println(div.calculate(100, 5));		
	}
}