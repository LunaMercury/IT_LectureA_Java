package Ch05;

public class C05ShiftArch {
	public static void main(String[] args) {
		int num1 = 15;		//00000000 00000000 00000000 00001111
		int num2 = 20;		//00000000 00000000 00000000 00010100
		int num3 = num1<<3; //00000000 00000000 00000000 01111000
		int num4 = num2>>3; //00000000 00000000 00000000 00000010
		
		System.out.println("<<Shift 연산결과 :" + num3);
		System.out.println(">>Shift 연산결과 :" + num4);
	}
}	
