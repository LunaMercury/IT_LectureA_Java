package Ch15;

public class C04ExceptionMain {

	public static void main(String[] args) {
		try {
			String str = null;
			str.toString();

			int arr[] = { 10, 20, 30 };
			arr[5] = 100;

			Integer.parseInt("a1234");

			Animal animal = new Dog();
			Cat yumi = (Cat) animal;

		} catch (NullPointerException e1) {
			System.out.println(e1);
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println(e2);
		} catch (NumberFormatException e3) {
			System.out.println(e3);
		} catch (ClassCastException e4) {
			System.out.println(e4);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
		} finally {
			// 자원정리작업
			System.out.println("Final test");
		}
		System.out.println("HELLO WORLD");
	}
}