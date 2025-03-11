package Ch17;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

public class C02Ex {
	public static void func1(List<String> list) {
		// ArrayList에 있는 정수값을 입력받는데 전달되는 수중에
		// 짝수의 값만 입력받는 코드를 작성하세요.

		// String을 Int로
		List<Integer> targetList = new ArrayList<>();
		for (String obj : list) {
			if (obj instanceof String) {
				targetList.add(Integer.parseInt((String) obj));
			}
		}
		// 짝수만
		List<Integer> evenli = new ArrayList();
		for (int i = 0; i < targetList.size(); i++) {
			if (targetList.get(i) % 2 == 0) {
				evenli.add(targetList.get(i));
			}
		}

		// 다시 String으로 만들고 list에 입력
		list.clear();
		for (Integer el : evenli) {
			list.add(Integer.toString(el));
		}
		System.out.println("짝수만 :" + list);

	}

	public static List<String> func2(List<String> list) {
		// ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수를 만드세요

		// 5보다 작은 숫자 삭제
		for (int i = 0; i < list.size(); i++) {
			if (Integer.parseInt(list.get(i)) < 5) {
				list.remove(list.get(i));
			} //????????? 미해결

		}
//		for (String el : list) {
//			if (Integer.parseInt(el) < 5) {
//				list.remove(el);
//			}
//		}
		System.out.println("5 이하 삭제 : " + list);
		return list;
	}

	public static int func3(List<String> list) {
		// ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구해보세요

		return -1; // 바꿔주세요 작업시
	}

	public static void main(String[] args) {
		List<String> li = new ArrayList();
		for (int i = 0; i < 30; i++) {
			String a = Integer.toString(i);
			li.add(a);
		}
		func1(li);
		List<String> returndList = func2(li);
		int sum = func3(returndList);
		System.out.println(sum);
	}

}
