package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface StringProcessor {
	List<String> process(List<String> list);
}

public class StringProcessorTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

		// 예시: 길이가 5 이상인 문자열만 추출
		StringProcessor longStrings = (strlist) -> list.stream().filter(obj -> ((String) obj).length() >= 5)
				.collect(Collectors.toList());

		List<String> result = longStrings.process(list);
		System.out.println(result); // 출력: [apple, banana, orange, grape]
	}
}