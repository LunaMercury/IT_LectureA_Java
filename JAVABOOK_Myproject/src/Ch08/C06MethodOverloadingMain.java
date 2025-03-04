package Ch08;

class C06Simple {
	int sum(int x, int y) {
		System.out.println("int sum(int x, int y)");
		return x + y;
	}

	int sum(int x, int y, int z) {
		System.out.println("int sum(int x, int y, int z)");
		return x + y + z;
	}

	int sum(double x, double y, double z) {
		System.out.println("int sum(double x, double y, double z)");
		return (int) (x + y + z);
	}
}

public class C06MethodOverloadingMain {

	public static void main(String[] args) {
		C06Simple obj = new C06Simple();
		obj.sum(10, 20);
		obj.sum(10, 20, 30);
		obj.sum(10.5, 20.5, 30.5);
		C06Simple obj2 = new C06Simple();
	}
}