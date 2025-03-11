package Ch17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C03SetMain {

	public static void main(String[] args) {
		Set<String> set = new HashSet();

		// 추가
		set.add("HTML/CSS/JS");
		set.add("JQUERY");
		set.add("NODEJS");
		set.add("SCSS");
		set.add("REACT");
		set.add("JAVA");
		set.add("JSP/SERVLET");
		set.add("STS");
		set.add("SPRING BOOT"); // older
		set.add("SPRING BOOT"); // new(덮어쓰기)

		// 조회
		// 구 방식
//		Iterator<String> iter = set.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		for (String el : set) {
			System.out.println(el);
		}

		System.out.println("갯수 확인 : " + set.size());
//		System.out.println("idx로 조회 : "+set.(2)); // Set은 id가 없어 아이디로 조회 불가
//		System.out.println("value 로 idx 확인 : "+set.indexOf("JAVA"));
		set.clear();
	}

}
