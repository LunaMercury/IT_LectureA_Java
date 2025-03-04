package Ch08;

class C02Person {
	// 속성
	String name;
	int age;
	float height;
	double weight;
}

public class C02PersonMain {

	public static void main(String[] args) {
		C02Person hong = new C02Person();
		hong.name = "홍길동";
		hong.age = 15;
		hong.height = 177.5f;
		hong.weight = 70.5;

		System.out.printf("%s %d %.2f %f\n", hong.name, hong.age, hong.height, hong.weight);
	}
}