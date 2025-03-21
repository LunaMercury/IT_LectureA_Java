package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class OddSum {

	public static Function<List<Integer>, Integer> getOddSum = (list) -> list.stream().filter(obj -> (int) obj % 2 == 1)
			.reduce(0, (a, b) -> a + b);

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		int oddSum = getOddSum.apply(list);
		System.out.println(oddSum); // 출력: 9
	}
}