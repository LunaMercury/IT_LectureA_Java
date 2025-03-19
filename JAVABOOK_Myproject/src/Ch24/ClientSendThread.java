package Ch24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSendThread implements Runnable {
	// OutputStream
	DataOutputStream dout;

	Scanner sc = new Scanner(System.in);

	ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {
		String send = null;
		while (true) {
			try {
				// CLIENT -> SERVER (송신)
				System.out.println("[CLIENT(q : 종료)] : ");
				send = sc.nextLine();
				if (send.equals("q")) {
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					dout.writeUTF(send);
					dout.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}