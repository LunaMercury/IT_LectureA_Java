package Ch06;

import java.nio.charset.Charset;
import java.util.Scanner;

public class C01IF {

	public static void main(String[] args) {
		// ---------------------------------------
		// 단순 if
		// ---------------------------------------
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		if (age >= 8)
//			System.out.println("학교에 다닙니다.");
//		System.out.println("첫 번째 IF 코드 블럭 종료");
//		if (age < 8)
//			System.out.println("학교에 다니지 않습니다.");
//		System.out.println("두 번째 IF 코드 블럭 종료");
//		System.out.println("프로그램 종료");
//
//		sc.close();

		// ---------------------------------------
		// if - else
		// ---------------------------------------
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		if (age >= 8)
//			System.out.println("학교에 다닙니다.");
//		else
//			System.out.println("학교에 다니지 않습니다.");
//		
//		System.out.println("프로그램 종료");
//
//		sc.close();

		// 문제 1
		// 정수 한개 값을 입력받아, 3의 배수이면 해당 수를 출력하세요
		// 3의 배수이면서 5의 배수이면 출력

//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("숫자를 입력하세요 : ");
//		int num1 = sc.nextInt();
//		boolean check = false;
//		if(num1%3 == 0 && num1%5 == 0) {
//			System.out.printf("%d 는 3의 배수이면서 5의 배수",num1).println();
//			check = true;
//		} else if(num1%3 == 0) {
//			System.out.printf("%d 는 3의 배수",num1).println();
//			check = true;
//		} else if(num1%5 == 0) {
//			System.out.printf("%d 는 5의 배수",num1).println();
//		} else {
//			System.out.println("3의 배수도, 5의 배수도 아닙니다.");
//		}
//		System.out.println(check);
//		
//		sc.close();

		// ---------------------------------------
		// 문제 2
		// 두 개의 정수를 입력받아 큰 수 출력

//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 숫자를 입력하세요 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 숫자를 입력하세요 : ");
//		int num2 = sc.nextInt();
//
//		if (num1 == num2) {
//			System.out.println("두 수는 같은 수입니다.");
//		} else {
//			int max = (num1 > num2) ? num1 : num2;
//			String suffix = (max % 10 == 0 || max % 10 == 4 || max % 10 == 5 || max % 10 == 9) ? "가" : "이";
//			System.out.printf("%d%s 큰 수 입니다.", max, suffix);
//		}
//
//		sc.close();

		// ---------------------------------------
		// 문제 3
		// 세 개의 정수를 입력받아 큰 수 출력

//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 숫자를 입력하세요 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 숫자를 입력하세요 : ");
//		int num2 = sc.nextInt();
//		System.out.print("세 번째 숫자를 입력하세요 : ");
//		int num3 = sc.nextInt();
//		int max = 0;
//
//		if (num1 == num2 && num2 == num3) {
//			max = num1;
//		} else if (num1 > num2 && num1 > num3) {
//			max = num1;
//		} else if (num2 > num3) {
//			max = num2;
//		} else {
//			max = num3;
//		}
//		if (num1 == num2 && num2 == num3) {
//			System.out.println("세 수는 같은 수입니다.");
//		} else {
//			String suffix = (max % 10 == 0 || max % 10 == 4 || max % 10 == 5 || max % 10 == 9) ? "가" : "이";
//			System.out.printf("%d%s 가장 큰 수 입니다.", max, suffix);
//		}
//		sc.close();

		// ---------------------------------------
		// 문제 4
		// 세개의 정수를 입력받아 해당수의 합과 평균을 출력

//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 숫자를 입력하세요 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 숫자를 입력하세요 : ");
//		int num2 = sc.nextInt();
//		System.out.print("세 번째 숫자를 입력하세요 : ");
//		int num3 = sc.nextInt();
//		int sum = num1 + num2 + num3;
//		int avg = sum / 3;
//
//		System.out.printf("세 수의 합은 %d입니다.", sum).println();
//		System.out.printf("세 수의 평균은 %d입니다.", avg).println();
//		
//		sc.close();

		// ---------------------------------------
		// 문제 5
		// 입력한 수가 짝수이고, 3의 배수라면 출력
		// 입력한 수가 홀수이고, 5의 배수라면 출력

//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("숫자를 입력하세요 : ");
//		int num = sc.nextInt();
//		String suffix = (num % 10 == 2 || num % 10 == 4 || num % 10 == 5 || num % 10 == 9) ? "는" : "은";
//		if (num % 2 == 0 && num % 3 == 0) {
//			System.out.printf("%d%s 짝수이고, 3의 배수", num, suffix);
//		} else if (num % 2 == 1 && num % 5 == 0) {
//			System.out.printf("%d%s 홀수이고, 5의 배수", num, suffix);
//		} else {
//			System.out.println("해당없음");
//		}
//
//		sc.close();

		// ---------------------------------------
		// if - else if - else
		// ---------------------------------------
		// 과목 1, 2, 3, 4 중 하나라도 40점 미만이면 불합격
		// 과목 평균이 100점 만점 기준으로 60점 미만이면 불합격
		// 이외 합격

//		Scanner sc = new Scanner(System.in);
//		int 과목1 = sc.nextInt();
//		int 과목2 = sc.nextInt();
//		int 과목3 = sc.nextInt();
//		int 과목4 = sc.nextInt();
//		double 평균 = (double) (과목1 + 과목2 + 과목3 + 과목4) / 4;
//
//		if (과목1 < 40 || 과목2 < 40 || 과목3 < 40 || 과목4 < 40 || 평균 < 60) {
//			System.out.println("불합격");
//		} else {
//			System.out.println("합격");
//		}
//		sc.close();

		// ---------------------------------------
		// 문제 6
		// 시험점수를 입력받아,
		// 90~100 : A
		// 80~89 : B
		// 70~79 : C
		// 60~69 : D
		// 나머지는 F를 출력하는 프로그램을 작성하시오

//		Scanner sc = new Scanner(System.in);
//		System.out.print("점수를 입력하세요 : ")
//		int score = sc.nextInt();
//		char result;
//
//		if (score > 90) {
//			result = 'A';
//		} else if (score > 80) {
//			result = 'B';
//		} else if (score > 70) {
//			result = 'C';
//		} else if (score > 60) {
//			result = 'D';
//		} else {
//			result = 'F';
//		}
//
//		if (score > 100) {
//			System.out.println("you typed wrong score");
//		} else {
//			System.out.printf("your result is %s", result);
//		}
//
//		sc.close();

		// ---------------------------------------
		// 문제 7
		// 나이별로 요금을 부과하는 else if문을 만드세요
		// 8세 미만 : 1000원
		// 14세 미만 : 2000원
		// 20세 미만 : 2500원
		// 이상 : 3000원

		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		int price = 3000;

		if (age < 8) {
			price = 1000;
		} else if (age < 14) {
			price = 2000;
		} else if (age < 20) {
			price = 2500;
		}

		System.out.printf("요금은 %d원 입니다.", price);
		sc.close();
	}
}
