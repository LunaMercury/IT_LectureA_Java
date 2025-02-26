package Ch03;

public class C07TypeChange {

	public static void main(String[] args) {
		// ----------------------------------
		// 문자열 + 문자열
		// ----------------------------------

		System.out.println("문자열1" + "문자열2");
		System.out.println("문자열1" + "문자열2"); // 문자열 + 문자열
		System.out.println("문자열1" + ',' + "문자열2"); // 문자열 + 문자 + 문자열
		System.out.println("문자열1" + 2); // 문자열 + 숫자
		System.out.println("문자열1" + ',' + '!');
		System.out.println(',' + '!' + "문자열"); // 단일 문자는 숫자로 취급. -> "77문자열" 이라는 결과가 나온다
		System.out.println("," + "!" + "문자열"); // 이와 같이 쌍따옴표를 사용해야 한다.

		// ----------------------------------
		// 문자열 -> 숫자형 변환
		// ----------------------------------
		// 문자열 -> 숫자형 변환(정수)

		System.out.println("10" + "20"); // 문자열 연결
		int n1 = Integer.parseInt("10"); // 웹개발코드시 폼으로부터 전달받은 값
		int n2 = Integer.parseInt("20");
		System.out.println(n1 + n2);

		// 문자열 -> 숫자형으로 변환(실수)
		double n3 = Double.parseDouble("10.5");
		double n4 = Double.parseDouble("20.4");
		System.out.println(n3 + n4);

		short n5 = Short.parseShort("5");
		short n6 = Short.parseShort("6");

		System.out.println(n5 + n6);
	}

}
