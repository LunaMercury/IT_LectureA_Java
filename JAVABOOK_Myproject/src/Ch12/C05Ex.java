package Ch12;

class Employee {
	// 속성
	public String name;
	private int age;
	private String addres;

	// getter, setter
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	// 생성자
	public Employee() {
	};

	public Employee(String name, int age, String addres) {
		super();
		this.name = name;
		this.age = age;
		this.addres = addres;
	}
}

class Parttimer extends Employee {
	// 속성
	private int hour_pay;

	// setter
	public void setHourPay(int pay) {
		this.hour_pay = pay;
	}

	// 생성자
	public Parttimer(String name, int age, String address, int hour_pay) {
		super(name, age, address);
		this.hour_pay = hour_pay;
	}

	@Override
	public String toString() {
		return "Parttimer [hour_pay=" + hour_pay + ", name=" + name + ", Age=" + getAge() + ", Addres=" + getAddres()
				+ "]";
	}

}

class Regular extends Employee {
	// 속성
	private int salary;

	// setter
	public void setSalary(int salary) {
		this.salary = salary;
	}

	// 생성자
	public Regular(String name, int age, String address, int salary) {
		super(name, age, address);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", name=" + name + ", Age=" + getAge() + ", Addres=" + getAddres() + "]";
	}

}

public class C05Ex {

	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동", 25, "대구", 20000);
		Regular emp2 = new Regular("서길동", 45, "울산", 50000000);
		System.out.println(emp1);
		System.out.println(emp2);
	}

}
