package Ch24;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientRecvThread implements Runnable {

	DataInputStream din;

	ClientRecvThread(DataInputStream din) {
		this.din = din;

	}

	@Override
	public void run() {
		String recv;

		try {
			while (true) {
				// SERVER -> CLIENT (수신)
				recv = din.readUTF();
				if (recv.equals("q")) {
					break;
				} else {
					System.out.println("[SERVER] : " + recv);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				din.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
