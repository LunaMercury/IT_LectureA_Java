package Ch17;

import java.util.HashMap;
import java.util.Map;

public class C06MapMain {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();

		// 추가
		map.put("aaa", 1111); // 입력 시 형태와 동일한 수를 넣어야 한다.
		map.put("bbb", 2222);
		map.put("ccc", 3333);
		map.put("ddd", 4444);
		map.put("ddd", 1234); // 중복 키

		// 삭제
		map.remove("aaa");
		

		// 확인
		System.out.println("SIZE : " + map.size());
		System.out.println("GET : " + map.get("bbb"));
		System.out.println("----------------------------------");

		// for
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}

	}

}
