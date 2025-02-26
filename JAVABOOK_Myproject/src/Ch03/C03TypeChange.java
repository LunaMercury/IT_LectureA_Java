package Ch03;

public class C03TypeChange {

	public static void main(String[] args) {
		int num1 = 129; // 00000000 00000000 00000000 10000001
		int num2 = 130; // 00000000 00000000 00000000 10000010
		byte ch1 = (byte) num1; // 마지막 1바이트만 존재, 10000001
		byte ch2 = (byte) num2; // 마지막 1바이트만 존재, 10000010

		System.out.println(ch1);
		System.out.println(ch2);
	}
}