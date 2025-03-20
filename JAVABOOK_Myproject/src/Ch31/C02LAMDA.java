package Ch31;

import java.util.Scanner;

interface Printer {
	// 추상 메서드
//	void print_1(String message);
	// 람다식을 적용할 때는 하나의 추상 메서드만 존재해야 한다. 아래는 불가.
//	String print_2(String message);
	String print_3();
}

public class C02LAMDA {

	public static void main(String[] args) {
		// 01
		// 이제까지 Printer printer = new Printer(message); 로 시작해서 printer~~ 를 해야했지만
		// 아래와 같이 람다스트림을 사용하여 바로 출력할 수 있다.
//		Printer printer1 = (message) -> {
//			System.out.println(message);
//		};
//		printer1.print_1("HELLO WORLD");

		// 02
//		Printer printer2 = message -> message + "HELLO WORLD";
//		String returnValue = printer2.print_2("TEST");
//		System.out.println(returnValue);

		// 03 (키보드로 입력받아 String 변환)
		Printer printer3 = () -> {
			Scanner sc = new Scanner(System.in);
			System.out.println("type message : ");
			String message = sc.next();			
			sc.close();
			return message + " HELLO WORLD";
		};
		System.out.println(printer3.print_3());		
	}
}