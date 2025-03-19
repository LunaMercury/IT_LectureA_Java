package Ch25;

import java.io.DataInputStream;
import java.io.IOException;

import org.bouncycastle.asn1.cmp.RevAnnContent;

public class ClientRecvThread implements Runnable {

	DataInputStream din;
	Cgui gui;

	ClientRecvThread(DataInputStream din, Cgui gui) {
		this.din = din;
		this.gui = gui;
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
					gui.area.append(recv + "\n");					
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
