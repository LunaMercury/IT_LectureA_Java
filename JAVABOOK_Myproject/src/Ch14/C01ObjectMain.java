package Ch14;

class A {
	int x;
	int y;
	@Override
	public String toString() {
		return "A [x=" + x + ", y=" + y + "]";
	}
}

public class C01ObjectMain {

	public static void main(String[] args) {
		A ob1 = new A();
		System.out.println(ob1);
		System.out.println(ob1.toString());
		
		Object ob2 = new Object();
		System.out.println(ob2);
		System.out.println(ob2.toString());
	}

}
