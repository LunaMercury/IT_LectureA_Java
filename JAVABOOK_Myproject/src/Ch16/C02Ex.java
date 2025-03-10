package Ch16;

abstract class 팝콘재료 {

	@Override
	public String toString() {
		return "팝콘재료";
	}
}

class 캬라멜 extends 팝콘재료 {

	@Override
	public String toString() {
		return "캬라멜";
	}
}

class 버터옥수수 extends 팝콘재료 {

	@Override
	public String toString() {
		return "버터옥수수";
	}
}

class PopCorn<T extends 팝콘재료> {
	private T meterial;

	public PopCorn(T meterial) {
		this.meterial = meterial;
	}

	@Override
	public String toString() {
		return "PopCorn [meterial=" + meterial + " 맛 팝콘]";
	}
}

public class C02Ex {

	public static void main(String[] args) {
		PopCorn<캬라멜> ob1 = new PopCorn<캬라멜>(new 캬라멜());
		System.out.println(ob1);

		PopCorn<버터옥수수> ob2 = new PopCorn<버터옥수수>(new 버터옥수수());
		System.out.println(ob2);
	}
}
