package Ch05;

public class C01BASIC {

	public static void main(String[] args) {
		// -------------------------
		// 기본 산술 연산자
		// -------------------------
//		int a = 10, b = 20, c;
//		System.out.println("a+b=" + (a + b));
//		System.out.println("a-b=" + (a - b));
//		System.out.println("a*b=" + (a * b));
//		System.out.println("b/a=" + (b / a)); // 나누기 - 몫
//		System.out.println("a%b=" + (a % b));// 나누기 - 나머지(1.짝홀수구분,2.배수구분,3.자리수제한,4.끝자리구하기)
//		System.out.println("-a=" + -a);

		// 문제
//		두수를 입력 받아 두수의 합/차/곱을 출력하는 프로그램을 만들어보세요
//		Scanner 를 사용합니다

		// -------------------------
		// 대입 연산자
		// -------------------------
		// LV = RV;
		// 공간 = 값(우선 처리);

		// -------------------------
		// 복합 대입 연산자(기본 산술 연산자 + 대입)
		// -------------------------
//		int a = 10;
//		a += 10; //a = a + 10;
//		a -= 5; // a = a-5;
//		a *= 3; // a = a*3;
//		System.out.println("a="+a);

		// -------------------------
		// 비교 연산자
		// -------------------------
//		int a = 10;
//		int b = 20;
//		System.out.println("A == B : " + (a == b)); // a=b
//		System.out.println("A  > B : " + (a > b));
//		System.out.println("A  < B : " + (a < b));
//		System.out.println("A >= B : " + (a >= b));
//		System.out.println("A <= B : " + (a <= b));
//		System.out.println("A != B : " + (a != b));

		// -------------------------
		// 논리 연산자
		// -------------------------
		// AND 연산자 && : (true)&&(true) = true , 그외는 거짓
		// - &&기호를 기준으로 왼/오른쪽 둘다 true 이면 true
		// OR 연산자 || : t||t = t, t||f =t, f||t=t, f||f=f
		// - ||기호를 기준으로 왼/오른쪽 중 하나만 true 이면 true
		// ! 연산자
		// - true이면 false, false 이면 true

//		int a = 10;
//		int b = 20;
//		System.out.println((a >= b) && (a > 5));
//		System.out.println((a != b) && (b > 15));
//
//		System.out.println((a >= b) || (a > 5));
//		System.out.println((a != b) || (b > 15));
//		System.out.println((a == b) || (a <= 5));
//
//		System.out.println("false AND false = " + (true && true));
//		System.out.println("false AND true = " + (false && true));
//		System.out.println("true AND false = " + (true && false));
//		System.out.println("true AND true =  " + (false && false));

		// -------------------------
		// 논리 부정 연산자
		// -------------------------
//		boolean play = true;
//		System.out.println(play);
//
//		play = !play;
//		System.out.println(play);
//
//		play = !play;
//		System.out.println(play);

		// -------------------------
		// 증감연산자
		// -------------------------
		// ++a(--a) : 전치 연산자 : 먼저 값 1증가(1감소) 이후 다른 연산자 처리
		// a++(a--) : 후치 연산자 : 다른 연산자 처리 먼저 한 후 1증가(1감소)
//		int a = 10, b = 10, c, d=0;

//		c = --a + b++;
//		d = a-- + ++b;
//		System.out.printf("a=%d , b=%d , c=%d, d=%d", a, b, c, d);

		// -------------------------
		// 삼항 연산자
		// -------------------------
		// (조건식)? 참인경우 실행코드 : 거짓인경우 실행코드;
//		int score = 85;
//		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
//		System.out.println(score + "점은 " + grade + "등급입니다.");

	}

}
