package Ch36;

import Ch36.Properties.CommonProperties;

public class Application {

	
	public static void main(String[] args) throws Exception {
		
		//01
//		FrontController frontController =  new FrontController();
//		Map<String,Object> params= new HashMap();
//		params.put("bookDto",new BookDto(1111,"JAVA의정석","EASY","111-111"));
//		frontController.execute("/book", 1, params);
//		System.out.println();
		
		//02
//		BookDaoImpl dao = new BookDaoImpl();
//		dao.Insert(new BookDto(1112,"JAVA의정석-2","EASY","111-112"));
//		dao.Insert(new BookDto(1113,"난정말JAVA를공부해본적이없다구요","00출판사","211-111"));
//		dao.Insert(new BookDto(1114,"JSP/SERVLET 기초","ㅋㅋ출판사","112-111"));
		
		//03
//		List<BookDto> list =  dao.SelectAll();
//		list.forEach(dto->{
//			System.out.println(dto);
//		});
//		System.out.println();
//		BookDto dto =  dao.Select(1112);
//		System.out.println(dto);
		
		//04
//		BookServiceImpl service = new BookServiceImpl();
//		List<BookDto> list =  service.getAllBooks();
//		list.forEach(dto->{
//			System.out.println(dto);
//		});
		
		//05
//		FrontController controller = new FrontController();
//		Map<String,Object> params = new HashMap();
//		params.put("bookDto",new BookDto(2222,"이것이C언어다","EASY","222-2222"));
//		Map<String,Object> result =   controller.execute("/book", 1, params);
//		Object response = result.get("response");

		//06
//		UserDaoImpl dao = new UserDaoImpl();
//		dao.Insert(new UserDto("user1","1234","ROLE_USER",false));
		

		//07
//		UserServiceImpl service = new UserServiceImpl();
//		service.UserJoin(new UserDto("user2","1234","ROLE_USER",false));

		
		
		//08
//		FrontController controller = new FrontController();		
//		Map<String,Object> params= new HashMap();
//		params.put("userDto",new UserDto("user3","1234","ROLE_USER",false));
//		controller.execute("/user", 1, params);
		
		//09
//		UserServiceImpl service = new UserServiceImpl();
//		service.UserJoin(new UserDto("user1","1234","ROLE_USER",false));
		
		//로그인실패 : 존재하지 않는계정
//		Map<String,Object> islogin1= service.login("user5","1234", 0);
//		System.out.println("islogin1 : " + islogin1);
		
//		//로그인실패 : 계정은 존재,패스워드 일치
//		Map<String,Object>  islogin2= service.login("user2","1235", 0);
//		System.out.println("islogin2 : " + islogin2);
//		
//		//로그인성공 : 계정은 존재하나 패스워드 불일치
//		Map<String,Object>  islogin3= service.login("user3","1234", 0);
//		System.out.println("islogin3 : " + islogin3);
//		Integer mySessionId = (Integer)islogin3.get("sessionId");
//		
//		//로그인실패 : 기존 로그인된 계정이 존재
//		Map<String,Object>  islogin4= service.login("user2","1234", mySessionId);
//		System.out.println("islogin4 : " + islogin4);
		
//		Map<String,Object>  isLogout01= service.logout(30);
//		System.out.println("isLogout01 :" + isLogout01);
		
		
//		FrontController controller = new FrontController();
//		Map<String,Object> params = new HashMap();
//		params.put("username", "user1");
//		params.put("password", "1234");
//		params.put("sessionId", 0);
//		Map<String,Object>response =controller.execute("/user", 6, params);
//		System.out.println(response);
		
//		params.put("sessionId", 31);
//		Map<String,Object>response =controller.execute("/user", 7, params);
//		System.out.println(response);
		
		
		//FrontController controller = new FrontController();
		
		CommonProperties a = CommonProperties.getInstance();
		
		
	}
	
	
}
