// 소켓통신(데이터 보내기)
// 동기이므로 한번씩 보내고 받기만 가능

package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7000); // 192.168.16.24:7000
		System.out.println("[INFO] SERVER SOCKET LISTENING");

		while (true) {
			// listening 상태
			Socket client = server.accept();

			// 아이피 확인
			System.out.println("CLIENT IP : " + client.getInetAddress());

			OutputStream out = client.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			InputStream in = client.getInputStream();
			DataInputStream din = new DataInputStream(in);

			//
			ServerSendThread send = new ServerSendThread(dout);
			ServerRecvThread recv = new ServerRecvThread(din);

			//
			Thread th1 = new Thread(send);
			Thread th2 = new Thread(recv);
			
			//실행
			th1.start();
			th2.start();
			// join은 thread가 동시에 실행되지 않도록 대기시키는 역할. th1과 th2가 동시 실행되지 않게.
			th1.join();
			th2.join();			

			// 자원제거
			in.close();
			out.close();
			client.close();
			server.close();

			System.out.println("[SERVER] 연결 종료");
		}
	}
}