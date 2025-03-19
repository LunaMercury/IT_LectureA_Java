// 양방향 통신
// 한 번씩 통신

package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

		Socket client = new Socket("192.168.16.21", 7000); // 접속을 할 곳

		System.out.println("CLIENT IP : " + client.getInetAddress());

		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);

		//
		ClientSendThread send = new ClientSendThread(dout);
		ClientRecvThread recv = new ClientRecvThread(din);

		//
		Thread t1 = new Thread(send);
		Thread t2 = new Thread(recv);

		//
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		out.close();		
		in.close();
		client.close();
		

		System.out.println("서버 종료합니다");
	}

}
