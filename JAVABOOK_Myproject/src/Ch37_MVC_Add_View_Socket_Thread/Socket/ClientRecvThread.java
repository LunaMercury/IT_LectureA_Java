package Ch37_MVC_Add_View_Socket_Thread.Socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Response;

public class ClientRecvThread  implements Runnable{



	
	public Socket client;
	public ClientBackground mvcClient;
	
	public ClientRecvThread(Socket client, ClientBackground mvcClient) throws IOException {
		this.client =client;
		this.mvcClient = mvcClient;
		
	}

	@Override
	public void run() {
		
			
			Object recv = new Object();
			try {	
				while(true)
				{
						BufferedInputStream bin = new BufferedInputStream(client.getInputStream());
						ObjectInputStream in = new ObjectInputStream(bin);
						recv= in.readObject();
					
					//서버로부터의 메시지 수신
					if(recv!=null) {
						Response response  = (Response)recv;
						Map<String,Object>body =  response.getBody();
						//
						mvcClient.recvObjects(body);	
					}
					
				}	
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
	
		
	}

}
