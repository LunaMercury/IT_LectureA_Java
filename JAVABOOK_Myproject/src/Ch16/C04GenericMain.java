package Ch16;

class Animal {
	String name;

	// 생성자 및 toString
	public Animal(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

}

class Panda extends Animal {

	// 생성자 및 toString
	public Panda(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}

}

class Tiger extends Animal {

	// 생성자 및 toString
	public Tiger(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}

}

public class C04GenericMain {

	// Generic
	public static <T extends Animal> void PrintByGeneric(T[] arr) {
		for (T t : arr) {
			System.out.println(t);
		}
		System.out.println("------------------");
	}
	// Object
	public static void PrintByObject(Object [] arr) {
		for (Object t : arr) {
			System.out.println(t);
		}
		System.out.println("------------------");
	}

	public static void main(String[] args) {
		Tiger arr1[] = {new Tiger("시베리안호랑이"), new Tiger("백두산호랑이")};
		Panda arr2[] = {new Panda("얼룩무늬판다"), new Panda("래서판다")};
		Object arr3[] = {new Tiger("벵갈호랑이"),new Panda("심천판다")};
		
		PrintByGeneric(arr1);
		PrintByGeneric(arr2);
		PrintByObject(arr3);

	}
}
