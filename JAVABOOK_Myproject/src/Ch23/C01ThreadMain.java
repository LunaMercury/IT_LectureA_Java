// 비동기작업과 유사하게, 개별적으로 작동

package Ch23;

public class C01ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK 01..");
			Thread.sleep(500);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK 02..");
			Thread.sleep(500);
		}
	}
}