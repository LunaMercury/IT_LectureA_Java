package Ch24;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ServerSendThread implements Runnable {

	// OutputStream
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	ServerSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {
		String send;
		try {
			while (true) {
				// SERVER -> CLIENT (송신)
				System.out.println("[SERVER(q : 종료)] : ");
				send = sc.nextLine();
				if (send.equals("q")) {
					break;
				}
				dout.writeUTF(send);
				dout.flush();
			}
		} catch (Exception e) {
			System.out.println("[EXCEPTION] 예외발생, ServerSendThread 종료");
		} finally {
			try {
				dout.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
