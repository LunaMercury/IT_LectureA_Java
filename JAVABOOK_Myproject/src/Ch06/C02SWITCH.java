package Ch06;

import java.util.Scanner;

public class C02SWITCH {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int ranking = sc.nextInt();
		char medalColor;
		switch (ranking) {
		case 1: {
			medalColor = 'G';
			System.out.println("메달색상 : G");
			break;
		}
		case 2: {
			medalColor = 'S';
			System.out.println("메달색상 : S");
			break;
		}
		case 3: {
			medalColor = 'B';
			System.out.println("메달색상 : B");
			break;
		}
		default: {
			medalColor = 'C';
		}

		}
		System.out.println(ranking + "등 메달의 색은 " + medalColor + "입니다.");
		sc.close();

	}
}
