package Ch07;

import java.util.Scanner;

public class C02While {

	public static void main(String[] args) {
		// 2단 - 9단 출력
//		int dan = 2;
//		while (dan < 10) {
//			int i = 1;
//			while (i <= 9) {
//				System.out.printf("%d * %d = %d", dan, i, dan * i).println();
//				i++;
//			}
//			System.out.println("");
//			dan++;
//		}

		// 9단-2단
//		int dan = 9;
//		while (dan > 1) {
//			int i = 9;
//			while (i >= 1) {
//				System.out.printf("%d * %d = %d", dan, i, dan * i).println();
//				i--;
//			}
//			System.out.println("");
//			dan--;
//		}
		// 별찍기
		Scanner sc = new Scanner(System.in);
		System.out.print("별의 높이?(4이상) :");
		int numOfStar = sc.nextInt();
		System.out.println("1 : 사각형");
		System.out.println("2 : 직각삼각형");
		System.out.println("3 : 직각역삼각형");
		System.out.println("4 : 붙은마름모");
		System.out.println("5 : 삼각형");
		System.out.println("6 : 마름모");
		System.out.println("별의 모양? :");
		int shapeOfstar = sc.nextInt();

		switch (shapeOfstar) {
		// 사각형
		case 1: {
			int i = 1;
			while (i <= numOfStar) {
				int j = 1;
				while (j <= numOfStar) {
					System.out.print("*");
					j++;
				}
				System.out.print("\n");
				i++;
			}
			break;
		}
		// 직각삼각형
		case 2: {
			int i = 1;
			while (i <= numOfStar) {
				int j = 1;
				while (j <= i) {
					System.out.print("*");
					j++;
				}
				System.out.print("\n");
				i++;
			}
			break;
		}
		// 직각역삼각형
		case 3: {
			int i = 1;
			while (i <= numOfStar) {
				int j = 1;
				while (numOfStar - j + 1 >= i) {
					System.out.print("*");
					j++;
				}
				System.out.print("\n");
				i++;
			}
			break;
		}
		// 붙은마름모
		case 4: {
			int i = 1;
			while (i <= numOfStar) {
				int j = 1;
				int half = (int) (numOfStar / 2);
				if (i <= half) {
					while (j <= i) {
						System.out.print("*");
						j++;
					}
				} else {
					while (numOfStar - j + 1 >= i) {
						System.out.print("*");
						j++;
					}
				}

				System.out.print("\n");
				i++;
			}
			break;
		}
		// 삼각형
		case 5: {
			int i = 1;
			// 공백은 하나씩, 별은 두개씩 늘어난다.
			while (i <= numOfStar) {
				int j = 1;
				int k = 1;
				// 각 줄의 공백 개수를 계산
				while (j <= numOfStar - i) {
					System.out.print(" ");
					j++;
				}
				while (k <= 2 * i - 1) {
					System.out.print("*");
					k++;
				}
				System.out.print("\n");
				i++;
			}

			break;

		}
		// 마름모
		case 6: {

			if (numOfStar % 2 == 1) {
				int i = 1;
				while (i <= numOfStar / 2) {
					int j = 1;
					int k = 1;
					while (j <= numOfStar / 2 - i + 1) {
						System.out.print(" ");
						j++;
					}
					while (k <= 2 * i - 1) {
						System.out.print("*");
						k++;
					}
					System.out.print("\n");
					i++;
				}
				while (i > numOfStar / 2 && i <= numOfStar) {
					int j = 1;
					int k = 1;
					while (j <= i - numOfStar / 2 - 1) {
						System.out.print(" ");
						j++;
					}
					while (k <= numOfStar * 2 - 2 * i + 1) {
						System.out.print("*");
						k++;
					}
					System.out.print("\n");
					i++;
				}
			} else {
				int i = 1;
				while (i <= numOfStar / 2) {
					int j = 1;
					int k = 1;
					while (j <= numOfStar / 2 - i) {
						System.out.print(" ");
						j++;
					}
					while (k <= 2 * i - 1) {
						System.out.print("*");
						k++;
					}
					System.out.print("\n");
					i++;
				}
				while (i > numOfStar / 2 && i <= numOfStar) {
					int j = 1;
					int k = 1;
					while (j <= i - numOfStar / 2 - 1) {
						System.out.print(" ");
						j++;
					}
					while (k <= numOfStar * 2 - 2 * i + 1) {
						System.out.print("*");
						k++;
					}
					System.out.print("\n");
					i++;
				}
			}

			break;
		}
		// 테스트
		case 99: {
			for (int i = 1; i <= numOfStar; i++) {
				// 공백 출력
				for (int j = 1; j <= Math.abs(numOfStar / 2 - i + 1); j++) {
					System.out.print(" ");
				}

				// 별 출력
				for (int k = 1; k <= (i <= numOfStar / 2 ? 2 * i - 1 : numOfStar * 2 - 2 * i + 1); k++) {
					System.out.print("*");
				}

				System.out.println();
			}
			break;
		}
		default: {
			int i = 1;
			while (i <= numOfStar) {
				int j = 1;
				while (j <= numOfStar) {
					System.out.print("*");
					j++;
				}
				System.out.print("\n");
				i++;
			}

		}
		}
		sc.close();
	}
}