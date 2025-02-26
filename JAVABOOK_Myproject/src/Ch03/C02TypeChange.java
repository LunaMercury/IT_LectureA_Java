package Ch03;

public class C02TypeChange {

	public static void main(String[] args) {
		int intValue = 44032;
		char charValue = (char) intValue;
		System.out.println((int) charValue);
		System.out.println(charValue);

		long longValue = 500;
		intValue = (int) longValue; // longValue 값이 작더라도 큰 자료형이 작은 자료형에 자동적으로 들어갈 수 없다. 강제 형변환이 필요하다.
		System.out.println(intValue);

		// 데이터손실
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue);
	}
}