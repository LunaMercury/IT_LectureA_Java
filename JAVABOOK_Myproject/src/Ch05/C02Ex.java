package Ch05;

import java.util.Scanner;

public class C02Ex {

	public static void main(String[] args) {

		// 1.문제(삼항연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다

		Scanner scanner = new Scanner(System.in);

//		System.out.print("국어 점수를 입력하시오 :");
//		int 국어 = scanner.nextInt();
//		System.out.print("영어 점수를 입력하시오 :");
//		int 영어 = scanner.nextInt();
//		System.out.print("수학 점수를 입력하시오 :");
//		int 수학 = scanner.nextInt();
//		int 평균 = (int) ((국어 + 영어 + 수학) / 3);
//		if (평균 >= 70) {
//			System.out.printf("평균점수 : %d. 합격", 평균);
//		} else {
//			System.out.printf("평균점수 : %d. 불합격", 평균);
//		}

		// 2.미니문제(%연산자)
		// 키보드로 부터 정수값 2 를 입력받아
		// 두수의 합이 짝수이면 "짝수입니다"
		// 홀수이면 "홀수입니다" 를 출력하세요~

//		System.out.print("첫 번째 번호를 입력하세요 : ");
//		int num1 = scanner.nextInt();
//		System.out.print("두 번째 번호를 입력하세요 : ");
//		int num2 = scanner.nextInt();
//
//		if ((num1 + num2) % 2 == 0) {
//			System.out.print("짝수입니다.");
//		} else {
//			System.out.print("홀수입니다.");
//		}

		// 3.문제
		// 국어 / 영어 / 수학 점수를 입력받아서
		// 국어 점수가 40점이상
		// 영어 점수가 40점이상
		// 수학 점수가 40점이상이면서 전체평균이 60점이상이면 합격을 출력
		// 아니면 불합격을 출력하세요
		// 삼항연산자와 논리연산자를 이용합니다.

		System.out.print("국어 점수를 입력하시오 :");
		int 국어 = scanner.nextInt();
		System.out.print("영어 점수를 입력하시오 :");
		int 영어 = scanner.nextInt();
		System.out.print("수학 점수를 입력하시오 :");
		int 수학 = scanner.nextInt();
		int 평균 = (int) ((국어 + 영어 + 수학) / 3);

		String result = (국어 >= 40 && 영어 >= 40 && 수학 >= 40 && 평균 >= 60) ? "합격" : "불합격";
		System.out.printf("평균점수 : %d. %s", 평균, result);
		// 스캐너 종료
		scanner.close();

	}

}
