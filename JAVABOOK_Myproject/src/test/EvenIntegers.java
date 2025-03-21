package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EvenIntegers {

	public static Function<List<Object>, List<Integer>> getEvenIntegers = (list) -> list.stream()
			.filter(obj -> obj instanceof Integer).filter(obj -> (int) obj % 2 == 0).map(obj -> (Integer) obj)
			.collect(Collectors.toList());

	public static void main(String[] args) {
		List<Object> list = Arrays.asList(1, 2, "a", 4, 5, "b", 6);
		List<Integer> evenList = getEvenIntegers.apply(list);
		System.out.println(evenList); // 출력: [2, 4, 6]
	}
}