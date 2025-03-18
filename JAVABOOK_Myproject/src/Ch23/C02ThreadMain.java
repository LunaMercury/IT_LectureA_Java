// 스레드 분할

package Ch23;

public class C02ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		// Runnable Interface 스레드 분할

		// 01 작업객체 생성
		C02Worker1 w1 = new C02Worker1();
		C02Worker2 w2 = new C02Worker2();
		// 02 메인스레드에서 분리
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		// 03 스레드 실행
		th1.start();
		th2.start();

		// Thread class 스레드 분할
		new Thread() {

			@Override
			public void run() {
				super.run();
				for (int i = 0; i < 5; i++) {
					System.out.println("TASK 03..");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();
		;

//		for (int i = 0; i < 5; i++) {
//			System.out.println("TASK 01..");
//			Thread.sleep(500);
//		}
//		for (int i = 0; i < 5; i++) {
//			System.out.println("TASK 02..");
//			Thread.sleep(500);
//		}
	}
}