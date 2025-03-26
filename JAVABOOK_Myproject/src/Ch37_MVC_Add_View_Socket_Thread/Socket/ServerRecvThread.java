package Ch37_MVC_Add_View_Socket_Thread.Socket;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Controller.FrontController;
import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Request;

public class ServerRecvThread  implements Runnable{
	String clientIp;
	Socket client;
	ObjectInputStream Din;
	
	ServerBackground serverBackground;
	FrontController frontController;
	
	public ServerRecvThread(Socket client,ServerBackground serverBackground) throws Exception{
		frontController = new FrontController();
		
		this.client=client;
		this.serverBackground = serverBackground;
		this.clientIp = client.getInetAddress().toString();
		System.out.println("ServerRecvThread's init ClientIp : " + clientIp);
		try {
			
			BufferedInputStream bin = new BufferedInputStream(client.getInputStream());
			Din = new ObjectInputStream(bin);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			Object recv;
			while(true)
			{
				recv= Din.readObject(); //클라이언트의 전달 메시지를 수신
				if(recv!=null) {
					
					Request request  = (Request)recv;
					Map<String,Object>body =  request.getBody();
					String uri = (String)body.get("uri");
					Integer serviceNo =(Integer)body.get("serviceNo");
					Map<String,Object> params = (Map<String,Object>)body.get("params");

					System.out.printf("ServerRecvThread run's %s : %s , %s , %s\n",clientIp,uri,serviceNo,params);
					// 요구사항 요청(to MVC)
					Map<String,Object> returnValue =  frontController.execute(uri, serviceNo, params);
					//결과 Send하기
					System.out.println("ServerRecvThread run's mvc returnVal  msg : " + returnValue.get("msg"));
					serverBackground.Response(clientIp, returnValue);
					
				}	
				
			}	
			
		}catch(Exception e) {
			//e.printStackTrace();	
			System.out.println("ServerRecvThread run's Exception.. e "+e);			
			serverBackground.removeClient(this.clientIp);
			System.out.println("ServerRecvThread run's Exception.. client : "+clientIp + " removed..");
			
		}
	}
	

}
