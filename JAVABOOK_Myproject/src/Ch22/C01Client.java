// 소켓통신(데이터 받기)
// 단발 통신

package Ch22;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class C01Client {

	public static void main(String[] args) throws UnknownHostException, IOException {		
		Socket client = new Socket("192.168.16.203", 7000); // 접속을 할 곳

		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		String recv = din.readUTF();
		System.out.println(recv);
		
		din.close();
		in.close();
		client.close();
		
		System.out.println("서버 종료합니다");
	}
}