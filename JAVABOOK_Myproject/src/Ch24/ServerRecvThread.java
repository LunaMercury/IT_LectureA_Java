package Ch24;

import java.io.DataInputStream;

public class ServerRecvThread implements Runnable {
	// InputStream
	DataInputStream din;

	ServerRecvThread(DataInputStream din) {
		this.din = din;
	}

	@Override
	public void run() {
		String recv;

		try {
			while (true) {
				// CLIENT -> SERVER (수신)
				recv = din.readUTF();
				if (recv.equals("q")) {
					break;
				} else {
					System.out.println("[CLIENT] : " + recv);
				}
			}
		} catch (Exception e) {
			System.out.println("[EXCEPTION] 예외발생, ServerReceiveThread 종료");
		} finally {
			try {
				din.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}