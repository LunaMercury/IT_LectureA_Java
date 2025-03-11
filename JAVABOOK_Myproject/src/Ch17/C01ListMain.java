package Ch17;

import java.util.ArrayList;
import java.util.List;

public class C01ListMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//추가
		list.add("HTML/CSS/JS");
		list.add("JQUERY");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");
		list.add("SPRING BOOT"); // 데이터 중복 허용
		
		// 조회
		System.out.println("갯수 확인 : "+list.size());
		System.out.println("idx로 조회 : "+list.get(2));
		System.out.println("value 로 idx 확인 : "+list.indexOf("JAVA"));
		
		// 삭제
		list.remove(0);
		list.remove("JQUERY");
		for (String el : list) {
			System.out.println(el);
		}
		System.out.println(list);
		
		//전체 삭제
		list.clear();
		System.out.println(list);
	}
}