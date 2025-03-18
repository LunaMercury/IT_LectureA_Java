// 동일한 자원에 여러 스레드가 접근할 때 정확한 결과를 위한 설정

package Ch23;

class IncrementThread implements Runnable {
	private static int counter = 0;

	private static final Object lock = new Object();

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100000; i++) {
			synchronized (lock) {
				// 작업 내용
				counter++; // 공유변수값증가
				System.out.println(Thread.currentThread().getName() + "s counter : " + counter);
				
				try {
					if(i<=99999) {
						lock.notifyAll(); // 다른 스레드에게 알림
						lock.wait(5); // 잠깐대기
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
}

public class C05ThreadMain_Ex_임계영역설정 {

	public static void main(String[] args) throws InterruptedException {

		IncrementThread incrementThread1 = new IncrementThread();
		IncrementThread incrementThread2 = new IncrementThread();
		IncrementThread incrementThread3 = new IncrementThread();
		IncrementThread incrementThread4 = new IncrementThread();

		Thread thread1 = new Thread(incrementThread1);
		Thread thread2 = new Thread(incrementThread2);
		Thread thread3 = new Thread(incrementThread3);
		Thread thread4 = new Thread(incrementThread3);

		thread1.setName("TH1");
		thread2.setName("TH2");
		thread3.setName("TH3");
		thread4.setName("TH4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		// 메인 스레드가 thread1,thread2의 작업이 모두 완료될 때까지 대기하도록 설정
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();

		System.out.println("Final value: " + incrementThread1.getCounter());

	}
}
