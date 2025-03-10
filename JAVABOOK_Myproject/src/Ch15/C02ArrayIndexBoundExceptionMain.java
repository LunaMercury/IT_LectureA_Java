package Ch15;

import Ch07.C03Continue_Break;

public class C02ArrayIndexBoundExceptionMain {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };

		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(arr[i]);
			}			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.println("HELLO WORLD");
	}

}
