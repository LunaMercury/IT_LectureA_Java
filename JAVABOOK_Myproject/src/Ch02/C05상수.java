package Ch02;

public class C05상수 {

	public static void main(String[] args) {
		// 리터럴 상수 : 이름부여X, 상수 pool에 저장, 단순한 수치, 값
		// 심볼릭 상수 : 이름부여O, final 예약어 사용
		
		// 리터럴 접미사 : 리터럴 상수가 저장되는 자료형을 지정
		// l,L : Long 자료형
		// f,F : float 자료형
		
		int a = 'a';
		System.out.println((int)a);
		System.out.println((char)a);
		
		int n1 = 100; //100은 리터럴 상수
		final int n2 = 200; //n2는 심볼릭 상수
		
		final double PI = 3.14;
		
		double result = PI*4*4;
	}
}