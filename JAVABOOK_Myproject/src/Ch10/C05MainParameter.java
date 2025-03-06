package Ch10;

public class C05MainParameter {

	public static void main(String[] args) {
		System.out.println("length : " + args.length);
		for (String parameter : args) {
			System.out.println(parameter);
		}
	}
}