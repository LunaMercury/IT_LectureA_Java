package Ch03;

public class C05TypeChange {

	public static void main(String[] args) {
		int num1 = 10, num2 = 4; // 동시에 자료형 명시 가능
		double dnum1 = num1 / num2; // int 나누기 int해서 소수점이 나와도 int라서 소수점 없다
		double dnum2 = (double) num1 / (double) num2; // 계산 시 double로 명시
		double dnum3 = (num1 * 1.0) / num2; // 하나만 자료형을 큰 것으로 바꿔도 그쪽으로 적용

		System.out.println("dnum1 :" + dnum1);
		System.out.println("dnum2 :" + dnum2);
		System.out.println("dnum3 :" + dnum3);
	}

}
