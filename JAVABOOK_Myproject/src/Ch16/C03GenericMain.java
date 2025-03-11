package Ch16;

class Person {
	String name;
	String age;
	String addr;

	// 생성자
	public Person(String name, String age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
}

class Man extends Person {

	public Man(String name, String age, String addr) {
		super(name, age, addr);
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

class Woman extends Person {

	public Woman(String name, String age, String addr) {
		super(name, age, addr);
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

class Couple<X extends Man, Y extends Woman> {
	private X member1;
	private Y member2;

	// 생성자, toString
	public Couple(X member1, Y member2) {
		super();
		this.member1 = member1;
		this.member2 = member2;
	}

	@Override
	public String toString() {
		return "Couple [member1=" + member1 + ", member2=" + member2 + "]";
	}
}

public class C03GenericMain {

	public static void main(String[] args) {
		Couple<Man, Woman> couple1 = new Couple(new Man("철수", "20", "대구"), new Woman("영희", "22", "대구"));
//		Couple<Man, Man> couple2 = new Couple(new Man("홍길동1", "25", "대구"), new Man("홍길동", "24", "대구"));
//		Couple<Integer, Integer> couple3 = new Couple(100, 200);
	}

}
