package Ch26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerRecvThread  implements Runnable{

	Socket client;
	DataInputStream Din;
	DataOutputStream Dout;
	ServerBackground background;
	ServerUI gui;
	String nick;
	
	public ServerRecvThread(Socket client,ServerBackground background,ServerUI gui){
		this.client=client;
		this.background = background;
		this.gui = gui;
		
		try {
			Din = new DataInputStream(client.getInputStream());
			Dout = new DataOutputStream(client.getOutputStream());
			String nick = Din.readUTF();
			this.nick = nick;
			System.out.println("닉네임 : " + nick + "님이 접속");
			this.background.addClient(nick,Dout);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			String recv;
			while(true)
			{
				recv=Din.readUTF(); //클라이언트의 전달 메시지를 수신
				if(recv!=null) {
					background.broadCast(nick,recv);
					gui.area.append(recv+"\n");
					gui.area.setCaretPosition(gui.area.getDocument().getLength()); //스크롤 하단으로 내리기
				}	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			background.removeClient(nick);
		}
		
	}

}
