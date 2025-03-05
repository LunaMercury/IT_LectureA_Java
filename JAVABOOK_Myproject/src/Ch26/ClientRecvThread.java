package Ch26;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientRecvThread implements Runnable{

	Socket client;
	DataInputStream Din;
	ClientUI gui;
	ClientRecvThread(Socket client,ClientUI ui){
		this.client=client;
		gui =ui;
	}
	
	@Override
	public void run() {
		
		try {
			Din = new DataInputStream(client.getInputStream());
			String recv;
			while(true)
			{
				recv=Din.readUTF(); //서버의 전달 메시지를 수신
				if(recv==null || recv.equals("q")) {
					gui.area.append("프로그램을 종료합니다");
					System.exit(-1);
				}
				gui.area.append(recv+"\n");
				gui.area.setCaretPosition(gui.area.getDocument().getLength()); //스크롤 하단으로 내리기
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
