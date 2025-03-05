package Ch09;

public class C04StringClass {

	public static void main(String[] args) {

		// stack heap class(method)

		String str1 = "java"; // "java"를 메모리에 저장하고 str1에 메모리 주소를 저장한다.
		String str2 = "java"; // "java"가 이미 메모리에 있으므로 str1과 동일한 메모리 주소를 저장한다.
		String str3 = new String("java"); // new이므로 heap 영역에 "java"를 저장하고 그 주소를 str3에 저장한다.
		String str4 = new String("java"); // new이므로 다시 새로이 heap 영역에 "java"를 저장하고 그 주소를 str4에 저장한다. str3의 메모리 주소와 다르다.

		System.out.printf("%X\n", System.identityHashCode(str1));
		System.out.printf("%X\n", System.identityHashCode(str2));
		System.out.printf("%X\n", System.identityHashCode(str3));
		System.out.printf("%X\n", System.identityHashCode(str4));
		System.out.println("----------------------------------");
		System.out.println("str1==str2 ? " + (str1 == str2));
		System.out.println("str3==str4 ? " + (str3 == str4));
		System.out.println("str1==str3 ? " + (str1 == str3));
		System.out.println("str2==str4 ? " + (str2 == str4));
		System.out.println("----------------------------------");
		System.out.println("str1==str2 ? " + (str1.equals(str2))); // 문자열 비교 함수 equals
		System.out.println("str3==str4 ? " + (str3.equals(str4)));
		System.out.println("str1==str3 ? " + (str1.equals(str3)));
		System.out.println("str2==str4 ? " + (str2.equals(str4)));
	}
}