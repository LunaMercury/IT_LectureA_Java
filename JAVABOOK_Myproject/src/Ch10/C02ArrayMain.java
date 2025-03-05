package Ch10;

import java.util.Arrays;

public class C02ArrayMain {

	public static void main(String[] args) {
		// 얕은복사 (주소복사)
		int arr1[] = { 10, 20, 30 };
		int arr2[]; // arr2 가 있다고 선언만 했을 뿐, 메모리는 확보하지 않았다.
		arr2 = arr1; // 값이 복사가 된 게 아니라 메모리 주소가 복사가 되었다.
		arr1[0] = 100; // 메모리 안의 값을 변화시켰으므로, 메모리 주소가 같은 arr1과 arr2 모두 바뀐다.

		// 두 메모리 주소가 같아서 같은 값이 나온다.
		Arrays.stream(arr1).forEach(System.out::println);
		Arrays.stream(arr2).forEach(System.out::println);

		// 깊은복사 (값복사)
		int arr3[] = new int[3]; // new를 사용해서 새로운 메모리가 확보되었다.
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr1[i];
		}

		// Arrays API (값복사)
		int arr4[] = Arrays.copyOf(arr1, arr1.length);

		//메모리 주소
		System.out.println("Arr1" + arr1);
		System.out.println("Arr2" + arr2);
		System.out.println("Arr3" + arr3);
		System.out.println("Arr4" + arr4);
	}
}