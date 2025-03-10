package Ch15;

public class C01NullpointerExceptionMain {

	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("예외발생 : " + e);
			System.out.println(e.getCause());
			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}

		System.out.println("HELLO WORLD");
		System.out.println("HELLO WORLD");
	}
}