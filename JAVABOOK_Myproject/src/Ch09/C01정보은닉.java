package Ch09;

// 접근 한정자
// 멤버, 클래스의 접근범위 제한을 위한 예약어
// public : 모든 클래스에서 접근 가능
// private : 해당 클래스에서만 접근 가능
// protected : 상속 관계를 가지는 경우에 접근가능
// default(기본) : 동일 패키지에 속한 클래스에서 접근 가능

class C01Person {
	private String name;
	private int age;
	String addr;

	// 생성자
	public C01Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// getter 함수(데이터를 외부로 반환할 때 사용. 데이터 수정은 불가)
	public String getName() {
		return this.name; //리턴으로 인해 밖으로 꺼내짐
	};

	// setter 함수(기존 데이터를 수정. 읽기는 불가)
	public void setAge(int age) {
		this.age = age; // =으로 인해 입력가능
	}
	// getter 와 setter는 인수가 private임이 전제
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}

public class C01정보은닉 {

	public static void main(String[] args) {
		C01Person person1 = new C01Person("홍길동", 25, "대구");
		System.out.println(person1.getName());		
	}
}