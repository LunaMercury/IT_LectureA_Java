// 양방향 통신
// 단발 통신

package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class C02Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket client = new Socket("192.168.16.203", 7000); // 접속을 할 곳

		System.out.println("CLIENT IP : " + client.getInetAddress());

		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);

		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);

		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		while (true) {
			// SERVER -> CLIENT (수신)
			recv = din.readUTF();
			if (recv.equals("q")) {
				break;
			} else {
				System.out.println("[SERVER] : " + recv);
			}

			// CLIENT -> SERVER (송신)
			System.out.println("[CLIENT(q : 종료)] : ");
			send = sc.nextLine();
			if (send.equals("q")) {
				break;
			} else {
				dout.writeUTF(send);
				dout.flush();
			}
		}

		din.close();
		in.close();
		client.close();
		sc.close();

		System.out.println("서버 종료합니다");
	}

}
