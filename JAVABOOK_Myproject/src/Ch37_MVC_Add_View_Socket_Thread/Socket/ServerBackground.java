package Ch37_MVC_Add_View_Socket_Thread.Socket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Properties.CommonProperties;
import Ch37_MVC_Add_View_Socket_Thread.Socket.Type.Response;

public class ServerBackground {
	
	CommonProperties properties;
	ServerSocket server;
	Map<String,Socket> ClientList; 
	Socket client;
	 
	
	public ServerBackground() throws IOException{
		properties = CommonProperties.getInstance();
		
		ClientList = new HashMap();
		Collections.synchronizedMap(ClientList);//컬렉션 동기화 
		System.out.println("ServerBackground");
		
	}
	
	//Client 접속 요청 수신용
	public void listenServer() {
		try {
			server = new ServerSocket( Integer.parseInt(properties.SERVERPORT) );
			while(true) {
				System.out.println("ServerBackground listenServer's Init");
				client=server.accept();
				System.out.println("ServerBackground listenServer's " + client.getInetAddress()+" Accept");
				
				//수신 스레드 처리 
				ServerRecvThread recv = new ServerRecvThread(client,this);
				Thread th = new Thread(recv);
				th.start();
				System.out.println("ServerBackground listenServer's recv Thread" + recv);
				
				//Server클라이언트 등록(IP주소 : Socket)
				ClientList.put(client.getInetAddress().toString(),client);
				System.out.println("ServerBackground listenServer's clientCount : " + ClientList.size());

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	//클라이언트 접속 제거
	public void removeClient(String ip) {
		System.out.println("ServerBackground removeClient's " + ip + " session Close..");
		ClientList.remove(ip);
	}
	
	//서버->클라이언트 응답용
	public void Response(String ip, Map<String,Object> returnValue) throws IOException {
		
		Socket client =  ClientList.get(ip);
		System.out.println("ServerBackground  response's client : " + client);
		BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());
		ObjectOutputStream out = new ObjectOutputStream(bout);
		Response response = new Response();
		response.setBody(returnValue);
		out.writeObject(response);
		out.flush();
	}
	
	
}
