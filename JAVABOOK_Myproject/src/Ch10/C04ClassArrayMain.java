package Ch10;

class C04Person {
	String name;
	int age;

	public C04Person() {
	}

	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}

}

public class C04ClassArrayMain {

	public static void main(String[] args) {
		
		C04Person list[] = new C04Person[3];
		
		list[0] = new C04Person();
		list[0].name="홍길동";
		list[0].age=55;
		
		list[1] = new C04Person();
		list[1].name="김영희";
		list[1].age=35;
		
		list[2] = new C04Person();
		list[2].name="김범수";
		list[2].age=40;
	}
}