//해시코드 재정의

package Ch14;

import java.util.Objects;

class C03Simple {
	int n;

	public C03Simple(int n) {
		this.n = n;
	}

	@Override
	public int hashCode() {
		return Objects.hash(n);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof C02Simple) {
			C02Simple down = (C02Simple) obj;
			return this.n == down.n;
		}
		return false;
		
		// 아래는 커멘드로 작성한 equal재정의
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		C03Simple other = (C03Simple) obj;
//		return n == other.n;
//	}

	}

	public class C03ObjectMain {

		public static void main(String[] args) {
			C03Simple ob1 = new C03Simple(1);
			System.out.println(ob1.toString());
			System.out.println(ob1.hashCode());

			C03Simple ob2 = new C03Simple(9);
			System.out.println(ob2.toString());
			System.out.println(ob2.hashCode());

			C03Simple ob3 = new C03Simple(9);
			System.out.println(ob2.toString());
			System.out.println(ob2.hashCode());

		}
	}
}