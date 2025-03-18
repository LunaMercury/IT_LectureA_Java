package Ch23;

public class C02Worker1 implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// 분할된 스레드에서 동작할 내용
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK 01..");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
