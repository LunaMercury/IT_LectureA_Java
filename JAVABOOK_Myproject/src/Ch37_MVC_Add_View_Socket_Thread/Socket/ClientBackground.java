package Ch37_MVC_Add_View_Socket_Thread.Socket;

import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Properties.CommonProperties;
import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Request;

public class ClientBackground {
	CommonProperties properties;
	
	
	public Socket client;
	public Map<String,Object> receiveBody;
	ObjectOutputStream out;
	public ClientBackground() throws Exception{
		
		this.properties = CommonProperties.getInstance();

		//접속요청
		
			client = new Socket(properties.SERVERIP ,Integer.parseInt(properties.SERVERPORT));
			System.out.println("[INIT] Server와 연결 완료.." + client);
			BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());
			out = new ObjectOutputStream(bout);
			
	
		
	}
	
	public void requestServer(Request request) throws Exception{
		out.writeObject(request);
		out.flush();
		//System.out.println("[Client] requestServer's receiveBody : " + receiveBody);
	}

	public void recvObjects(Map<String, Object> body) {
		System.out.println("[Client] recvObjects's receiveBody msg: " + body.get("msg") + " response : " + body.get("response"));
		this.receiveBody = body;
	}
		 
		
	
}
