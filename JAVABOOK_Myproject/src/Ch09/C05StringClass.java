package Ch09;

public class C05StringClass {

	public static void main(String[] args) {
		String str1 = "Java Powerful";
		String str2 = new String("Java Programming");
		String str3 = str1 + str2;
		String str4 = str1.concat(str2); // 문자열에 문자열 덧붙이기

		System.out.printf("%X\n", System.identityHashCode(str1));
		System.out.printf("%X\n", System.identityHashCode(str2));
		System.out.printf("%X\n", System.identityHashCode(str3));
		System.out.printf("%X\n", System.identityHashCode(str4));
		System.out.println("---------------------------------------");

		String str5 = "";		
		for (int i = 0; i < 10; i++) {
			str5 += i;
			System.out.print("str5 : " + str5 + "");
			System.out.printf("%X\n", System.identityHashCode(str5));
		}

		System.out.println("---------------------------------------");
		StringBuilder str6 = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			str6.append(i);
			System.out.print("str6 : " + str6 + "");
			System.out.printf("%X\n", System.identityHashCode(str6));
		}

		System.out.println("문자열 길이 : " + str1.length());
		System.out.println("한문자 찾기 : " + str1.charAt(2)); // 3번째 문자. 0부터 시작
		System.out.println("인덱스 찾기 : " + str1.indexOf('a')); // 2번째. 0부터 시작
		System.out.println("인덱스 찾기 : " + str1.lastIndexOf('a')); // 마지막으로 a가 나온 곳이 몇번째인지
		System.out.println("문자열 포함 여부 : " + str1.contains("va"));
		System.out.println("문자열 포함 여부 : " + str1.contains("abs"));
		System.out.println("문자열 자르기 : " + str1.substring(2, 6)); //2이상 6미만. 5번째까지 나온다.

		String str7 = "등산,탁구,축구,골프,독서,영화감상";
		String[] result = str7.split(","); // 배열 형태로 반환

		for (String hobby : result) {
			System.out.println(hobby);
		}
	}

}
