package Ch03;

public class C04TypeChange {

	public static void main(String[] args) {
		// 정수 연산식(int보다 작은 변수자료형(short, char, byte))
		// int로 자동 형변환
		byte x = 10;
		byte y = 20;
		byte result1 = (byte) (x + y); // xy는 byte이지만, 덧셈 처리를 하는 과정에서 다시 xy가 int형으로 변환이 된다. 그러므로 int x + int y 처리하도록 한뒤
										// 그 결과를 다시 강제형변환해야한다.

		int result2 = x + y;
		System.out.println("result1 :" + result1);

		// 정수 연산식(int보다 큰 변수자료형(long))
		// 큰 타입으로 자동 형변환
		byte var1 = 10;
		int var2 = 100;
		long var3 = 1000L;
		int result3 = var1 + var2 + (int) var3;
		long result4 = var1 + var2 + var3;
		System.out.println("result3 :" + result3);
		System.out.println("result4 :" + result4);

		// 실수 연산식
		// 큰 타입으로 자동 형 변환
		int intvar = 10;
		float flvar = 3.3f;
		double dbvar = 5.5;
		int result5 = (int) (intvar + flvar + dbvar); // float와 double의 소숫점 데이터 손실
		double result6 = intvar + flvar + dbvar;
		System.out.println("result5 :" + result5);
		System.out.println("result6 :" + result6);

	}
}