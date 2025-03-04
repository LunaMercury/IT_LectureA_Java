package Ch07;

import java.util.Iterator;
import java.util.Scanner;

public class C04For {

	public static void main(String[] args) {
//		int i = 0; // 탈출용 변수 선언
//		while (i < 10) { // 탈출용 조건식
//			System.out.println("HELLO WORLD");
//			i++;
//		}

		// for(탈출용 변수 선언; 탈출용 조건식; 탈출용 연산식){}
//		for (int i = 0; i < 10; i++) {
//			System.out.println("HELLO WORLD");
//		}

		// 1-10 까지의 합
		// 1-N 까지의 합
		// N-M 까지의 합
		// 2단 구구단
		// N단 구구단
		// 2-9 구구단
		// 2-N 구구단
		// N-M 구구단
		// 별찍기(정삼각형)
		Scanner sc = new Scanner(System.in);
		System.out.print("별의 높이?(4이상) :");
		int numOfStar = sc.nextInt();

		for (int i = 0; i <= numOfStar; i++) {
			for (int j = 0; j <= numOfStar - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		sc.close();
	}
}