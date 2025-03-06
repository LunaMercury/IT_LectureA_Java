package Ch11;

class Company {
	int n1;
	int n2;

	// toString
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}

	// 싱글톤 패턴 구조
	
	// 1. 공유 선언
	private static Company instance;

	// 2. 생성자 억제
	private Company() {
	} // priave 생성자로 인해 아래에서 Company test = new Company() 가 불가능해진다.

	// 3. get인스턴스
	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}
}

public class C03SingletonPattern {

	public static void main(String[] args) {
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		Company com3 = Company.getInstance();
//		Company com4 = new Company(); // priave 생성자로 인해 실행불가
		com1.n1 = 100;
		System.out.println("com1 : " + com1);
		System.out.println("com2 : " + com2);
	}
}