package Ch37_MVC_Add_View_Socket_Thread.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Ch37_MVC_Add_View_Socket_Thread.Application;



public class CommonProperties {
	
	//전역 설정 값들.. application.properties 로부터 읽어온다..
	public static String DBURL;
	public static String DBID;
	public static String DBPW;
	public static String SERVERPORT;
	public static String SERVERIP;
	
	private Properties properties; //05-03
	
	private static CommonProperties instance ;
	public static CommonProperties getInstance() throws IOException {
		if(instance==null)
			instance = new CommonProperties();
		return instance;
	}
	
	private CommonProperties() throws IOException{
		//05-03 application.properties
		properties = new Properties();
		String classPath = System.getProperty("java.class.path");
		String dirPath = System.getProperty("user.dir");
		
		String pakagePath = Application.class.getPackageName();
		String filePath = dirPath + File.separator + "src" + File.separator + pakagePath + File.separator +"application.properties";
		 
		System.out.println("filePath : " + filePath);
		FileInputStream fin = new FileInputStream(filePath);	
		properties.load(fin);
		
		String url=properties.getProperty("com.project.library.database.url");
		String username=properties.getProperty("com.project.library.database.id");
		String password=properties.getProperty("com.project.library.database.pw");
		String port=properties.getProperty("server.port");
		String ip=properties.getProperty("server.ip");


		System.out.println("CommonProperties's properties url : " + url  );
		System.out.println("CommonProperties's properties username: " + username);
		System.out.println("CommonProperties's properties password: " + password);
		System.out.println("CommonProperties's properties port: " + port);
		System.out.println("CommonProperties's properties ip : " + ip);
		
		this.DBID = username;
		this.DBPW = password;
		this.DBURL = url;
		this.SERVERPORT = port;
		this.SERVERIP=ip;
		
	}
}
