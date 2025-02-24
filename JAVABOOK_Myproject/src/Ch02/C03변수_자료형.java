package Ch02;

public class C03변수_자료형 {

	public static void main(String[] args) {

		// Data(수, 자료) : 선저장 후처리
		// 변수 : 개발자의 유지보수 측면에서 바뀔 예정이 큰 수
		// 변수명 : 저장되어져 있는 변수 공간에 접근하기 위한 문자 형태의 주소
		// 자료형 : Data를 저장하기 위한 공간을 형성하는 예약어(+제약조건)
		
		// lv(공간) = rv(값)		rv를 먼저 처리(저장 또는 연산)한 다음 lv에 대입

		int num1; 					// 4byte 정수 공간 형성 + num1 이름 부여(변수 정의)
		num1 = 10;					// 10리터럴 상수값을 상수 Pool에 저장, num1 공간에 값 대입(복사)
		int num2 = 4;				// 4 리터럴 상수값을 상수Pool에 저장, 4byte 정수공간 num2에 초기값으로 대입
		int num3 = num1 + num2;		// num1의 값과 num2안의 값의 +연산결과 값을 4byte 정수 공간 num3에 초기화
		System.out.println(num3);	// num3안의 값을 println
	}
}
