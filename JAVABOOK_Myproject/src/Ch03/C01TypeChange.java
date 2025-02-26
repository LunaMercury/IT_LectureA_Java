package Ch03;

public class C01TypeChange {

	public static void main(String[] args) {
		// 자료형 변환
		// 연산 시 일치하지 않는 자료형을 일치시키는 작업
		
		// 자동형변환(임시적 형변환) : 컴파일러에 의해 자동 형변환
		// 강제형변환(명시적 형변환) : 프로그래머에 의해 강제 형변환
		
		// 자동형변환(=)
		// 변수간 연산처리 시 범위가 넓은 공간에 작은 값이 대입되는 경우
		// 리터럴 상수 연산처리 시 리터럴 값에 따른 형변환 여부 결정
		// byte > short,char > int > long > float > double
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue :" + intValue);
		
		char charValue = '가';
		intValue = charValue;
		System.out.println("\"가\" 의 유니코드 :" + intValue);
		
		intValue = 50;
		long longValue = intValue; 
		System.out.println("longValue :" + longValue);

		longValue = 100;
		float floatValue = longValue;
		System.out.println("floatValue :" + floatValue);
		
		floatValue = 100.5f;
		double doubleValue = floatValue;
		System.out.println("doubleValue :" + doubleValue);

	}

}
