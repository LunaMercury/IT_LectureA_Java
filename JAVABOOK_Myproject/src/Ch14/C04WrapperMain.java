// Wrapper
// int n1 대신에 Integer n1을 사용하는 이유는 null 체크를 위해서이다.
// 다른 파일(.json 등)에서 숫자를 받아올 때 int형이 아닐 수도 있다. 이 데이터를 int형으로 처리하기 위함.
// 숫자가 없으면 null 처리가 된다.

package Ch14;

public class C04WrapperMain {

	public static void main(String[] args) {
		Integer ob1 = new Integer(100);
		Integer ob2 = new Integer("100"); // 숫자가 문자열로 입력되더라도 자동으로 int형으로 변환되어 저장된다.
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1 + ob2 + ob3);

		// UnBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue();
		int n3 = ob3.intValue();
		System.out.println(n1 + n2 + n3);

		// Auto Boxing
		Integer ob4 = 100;
		int n4 = ob1 + ob2 + ob3;

	}
}