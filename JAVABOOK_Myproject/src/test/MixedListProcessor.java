package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import net.bytebuddy.asm.Advice.Return;

public class MixedListProcessor {

	public static Function<List<Object>, List<Object>> processMixedList = (list) -> list.stream().map((obj) -> {
		if (obj instanceof Integer) {
			return obj = (Integer) obj * (Integer) obj;
		} else if (obj instanceof String) {
			return ((String) obj).toUpperCase();
		} else {
			return obj;
		}
	}).collect(Collectors.toList());

	public static void main(String[] args) {
		List<Object> list = Arrays.asList(1, "apple", 2, "banana", 3, "orange");
		List<Object> result = processMixedList.apply(list);
		System.out.println(result); // 출력: [1, APPLE, 4, BANANA, 9, ORANGE]
	}
}