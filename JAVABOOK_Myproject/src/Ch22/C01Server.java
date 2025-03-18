// 소켓통신(데이터 보내기)
// 받아서 뿌리는 형태

package Ch22;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {
	public static void main(String[] args) throws IOException {
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7000); // 192.168.16.24:7000
		System.out.println("[INFO] SERVER SOCKET LISTENING");

		while (true) {
			// listening 상태
			Socket client = server.accept();

			//
			System.out.println("CLIENT IP : " + client.getInetAddress());
			OutputStream out = client.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);

			dout.writeUTF("[INFO] 비밀 댓글입니다");
			dout.flush();
			dout.close();
			client.close();
			server.close();

		}

	}
}
