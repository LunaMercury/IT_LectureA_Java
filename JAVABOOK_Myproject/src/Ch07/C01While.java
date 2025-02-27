package Ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class C01While {

	public static void main(String[] args) {
		// 10번반복 - "HELLO WORLD"
		// 탈출용 변수 : i=0
		// 탈출용 조건식 : i<10
		// 탈출용 연산식 : i++
//		while(조건식) {
//			조건식이 true 인동안 실행되는 종속문장
//		}

		// 01 기본 - HELLO WORLD 10회 반복
//		int i=0;
//		while(i<10) {
//			System.out.println("HELLO WORLD");
//			i++;
//		}

		// 02 기본 - HELLO WORLD N회 반복
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i=0;
//		while(i<n) {
//			System.out.println("HELLO WORLD");
//			i++;
//		}

		// 03 기본 - 1부터 10까지의 합

//		int i = 1;		//탈출용 변수
//		int sum = 0;	//누적합 변수
//		while(i<=10)	//탈출용 조건식 
//		{
//			System.out.println("i : " + i);
//			sum = sum + i;
//			i++;		//탈출용 연산식
//		}
//		System.out.println("SUM : " + sum);

		// 04 기본 - 1부터 N까지 합

//		Scanner sc  = new Scanner(System.in);
//		int i = 1;		//탈출용 변수
//		int sum = 0;	//누적합 변수
//		int n = sc.nextInt();
//		while(i<=n)	//탈출용 조건식 
//		{
//			System.out.println("i : " + i);
//			sum = sum + i;
//			i++;		//탈출용 연산식
//		}
//		System.out.println("SUM : " + sum);	

		// 05 기본 - N부터 M까지 합(N<M) - N>=M 인경우 N과 M을 Swap하고 진행합니다

//		Scanner sc  = new Scanner(System.in);
//
//		int n = sc.nextInt();	//시작값
//		int m = sc.nextInt();	//종료값
//		
//		if(n>=m) {
//			//잘못 입력한경우(시작값(n)이 끝값(m)보다 큰경우 , (5,3)...)
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		
//		int i = n;		//탈출용 변수
//		int sum = 0;	//누적합 변수
//		while(i<=m)	//탈출용 조건식 
//		{
//			System.out.println("i : " + i);
//			sum += i;		//sum = sum + i; 
//			i++;		//탈출용 연산식
//		}
//		System.out.println("SUM : " + sum);	

		// 06 N - M까지 수중(N<M) 짝수의합, 홀수의 합을 각각 구해서 출력하세요
		// 예시)
		// n= 3(키보드로 입력된 값)
		// m = 7(키보드로 입력된 값)
		// 짝수의 합 : 10
		// 홀수의 합 : 15

		// 07 1 - N 까지 수중에 4의 배수를 출력하고 4의배수가 아닌 나머지의 합을 구하세요
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = 1;
		int sum = 0;
		List<Integer> multiples = new ArrayList<Integer>();
		while (i <= num) {
			if (i % 4 == 0) {
				multiples.add(i);
			} else {
				sum = sum + i;
			}
			i++;
		}
		System.out.println(num+"의 4의 배수는 ");
		for (int j = 0; j<multiples.size(); j++) {
			System.out.print(multiples.get(j));
			System.out.print(", ");
		}
		
		System.out.printf("나머지 합은 %d입니다.", sum).println();

		sc.close();

		// 08 구구단 N단을 출력합니다(2<=N<=9)

//		Scanner sc = new Scanner(System.in);
//		System.out.print("몇 단을 출력할까요? :");
//		int j = sc.nextInt();
//		System.out.print("몇 단까지 출력할까요? :");
//		int i = sc.nextInt();;
//		int k = 1;
//		
//		while (k <= i) {
//			System.out.printf("%d * %d = %d", j, k, j * k).println();
//			k++;
//		}
//		
//		sc.close();

	}

}
