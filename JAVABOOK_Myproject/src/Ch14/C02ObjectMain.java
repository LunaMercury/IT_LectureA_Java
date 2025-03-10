// equal 재정의
// object의 equal은 메모리 주소를 비교함.
// equal을 재정의 함으로서 메모리 주소 비교가 아니라 값을 비교할 수 있다.

package Ch14;

class C02Simple {
	int n;

	public C02Simple(int n) {
		this.n = n;
	}

	@Override
	// equals 재정의 없이 아래의 ob1.equals(ob2) 를 사용하면 ob1의 메모리 주소와 ob2의 메모리 주소를 비교하는 것이므로,
	// n이 같은 10이라도 new를 사용하였으므로 false가 나오게 된다.
	public boolean equals(Object obj) {
		if (obj instanceof C02Simple) {
			C02Simple down = (C02Simple) obj;
			return this.n == down.n;
		}
		return false;
	}

}

public class C02ObjectMain {

	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);

		System.out.println(ob1);
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));

		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		System.out.println(str1.equals(str2));

	}
}