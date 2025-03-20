package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	protected String name;
	protected int age;

	Person() {
	}	

	public Person(String name, int age) {
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
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

class employee extends Person{
	String Compnany;
	String department;
	String role;
		
	public employee() {	
	}
	public employee(String name, int age) {
		super(name,age);
	}
	public employee(Person person) {
		this.name = person.getName();
		this.age = person.getAge();		
	}
	
	public employee(String compnany, String department, String role) {
		super();
		Compnany = compnany;
		this.department = department;
		this.role = role;
	}
	public String getCompnany() {
		return Compnany;
	}
	public void setCompnany(String compnany) {
		Compnany = compnany;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "employee [Compnany=" + Compnany + ", department=" + department + ", role=" + role + ", getName()="
				+ getName() + ", getAge()=" + getAge() + "]";
	}
	
	

	
}

public class C01StreamMain {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);

		// filter
		List<Integer> list2 = list.stream().filter((item) -> {
			return item % 2 == 0;
		}).collect(Collectors.toList());
		System.out.println("짝수 필터링 : " + list2);

		// Map 적용
		List<Integer> list3 = list.stream().filter((item) -> {
			return item % 2 == 0;
		}).map(item -> item * item).collect(Collectors.toList());
		System.out.println("MAP 적용 : " + list3);

		List<Person> list4 = Arrays.asList(new Person("홍길동1", 55), new Person("남길동22", 35), new Person("서길동333", 45),
				new Person("동길동4444", 25));
		
		// list 5와 list 5_2의 결과는 같다. 5_3은 정렬 포함.
		List<Integer> list5_1 = list4.stream()
				.map((person)->{return person.getAge();})
				.collect(Collectors.toList());
		List<Integer> list5_2 = list4.stream()
				.map(person -> person.getAge())
				.collect(Collectors.toList());		
		List<Integer> list5_3 = list4.stream()
				.map(Person::getAge)
				.sorted((a,b)->{return b-a;})
				.collect(Collectors.toList());
		System.out.println("person의 age값만 추출 : "+list5_3);
		
		List<Integer> list6=
		list4.stream().map(Person::getName).map(String::length).sorted((a,b) -> a-b).collect(Collectors.toList());
		System.out.println(list6);
		
		List<employee> list7 = list4.stream()
//				.map(person->new employee(person.getName(), person.getAge())) // 아래 코드와 동일
				.map(employee::new)
				.collect(Collectors.toList());
		list7.forEach(System.out::println);
	}
}