package Ch36.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class FrontController {
	
	
	
	private Map<String,SubController> map = new HashMap();
	
	public FrontController() throws Exception{
		System.out.println("FrontController()");
		init();

		
	}
	private void init() {
		System.out.println("FrontController's init()");
		//요청 API 
		//  /book - BookController
		//  /member - MemberController
		//  /lend	- LendController
		map.put("/book", new BookController());
		map.put("/user", new UserController());
		map.put("/lend", new LendController());		
	}
	
	//사용자의 요청 uri 에 맞는 subController를 가져와 execute를 실행
	public Map<String,Object> execute(String uri,int ServiceNo,Map<String,Object> params)
	{
		System.out.println("FrontController's execute()");
		SubController controller =  map.get(uri);
		return controller.execute(ServiceNo, params);
	}
	
	

}
