package Ch01;

public class C01Systemout {

	public static void main(String[] args) {
		// \n : 줄바꿈
		// \b : 백스페이스
		// \t : 탭
		System.out.print("Hello World\n");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");

		// System.out.printf()
		// format
		// %d : 10진수 정수 서식문자
		// %f : 10진수 실수 서식문자
		// %c : 한 문자. 서식문자
		// %s : 문자열. 서식문자
		System.out.printf("%d %d %d\n", 10, 20, 30);
		System.out.printf("%f %f %f\n", 10.1, 20.2, 30.3);
		System.out.printf("%c %c %c\n", 'A', 'B', 'c'); // 작은 따옴표만 됨
		System.out.printf("%s %s %s\n", "This is", "String", "test");
		System.out.printf("%d.%s : %d\n", 1, "국어", 100);

		// System.out.println() : 자동 줄바꿈
		System.out.println("Hello World");
		System.out.println("Hello World");

	}

}
