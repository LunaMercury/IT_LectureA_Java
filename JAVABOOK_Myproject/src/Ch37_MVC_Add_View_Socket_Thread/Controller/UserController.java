package Ch37_MVC_Add_View_Socket_Thread.Controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao.Common.ConnectionPool_ByHikari;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.UserDto;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Service.UserService;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Service.UserServiceImpl;





public class UserController implements SubController{
	
	private UserService userService;
	
	//05-02 TX Hikari
	private ConnectionPool_ByHikari connectionPool_ByHikari;//05-02 Hikari

	
	public UserController(){
		
		try {
			userService=UserServiceImpl.getInstance();
		
			
			//05-02 TX Hikari
			this.connectionPool_ByHikari = ConnectionPool_ByHikari.getInstance();//05-02 Hikari

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 6 Login 7 Logout 
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("UserController's execute()");
		if(serviceNo==1) {
			
			//01 파라미터
			UserDto dto = (UserDto)params.get("userDto");
			
			//02 유효성
			if(!isValid(dto)) {
				return null;
			}
			//03 서비스
			boolean isJoined=false;
			
			try {
				isJoined =  userService.UserJoin(dto);
			
			} catch (Exception e) {
				//------------------------
				//05-02 TX Hikari 
				//------------------------
				try {connectionPool_ByHikari.txRollBack();} catch (SQLException e1) {e1.printStackTrace();}
				//------------------------
				e.printStackTrace();
			}
			
			//04 뷰
			Map<String,Object> result = new HashMap();
			result.put("response", isJoined);
			
			
		}else if(serviceNo==2) {
			
		}else if(serviceNo==3) {
			
		}else if(serviceNo==4) {
			
		}else if(serviceNo==5) {
			
		}else if(serviceNo==6) {
			
			// 01 파라미터
			String username =(String) params.get("username");
			String password =(String) params.get("password");
			Integer sessionId = (Integer)params.get("sessionId");
						
			
			// 02 입력값(Data)
			if(!isValid(username,password,sessionId)) {
				return null;
			}
			// 03 서비스
			Map<String,Object> response = null;
			try {
				response = userService.login(username, password, sessionId);
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 04 뷰 
			return response;
			
			
		}else if(serviceNo==7) {
			//파라미터 
			Integer sessionId =(Integer)params.get("sessionId");
			
			//입력값 검증
			Map<String,Object> response =null;
			if(!isValid(sessionId)) {
				response = new HashMap();
				response.put("response", false);
				response.put("msg", "Data Validation Check Error..");
				return response;
			}
				
			//서비스		
			try {
				response = userService.logout(sessionId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//뷰
			return response;
			
		}else {
			;
		}
		return null;
	}
	
	private boolean isValid(Integer sessionId) {
		// TODO Auto-generated method stub
		return true;
	}
	private boolean isValid(String username, String password, Integer sessionId) {
		// NullCheck
		// trim
		return true;
	}
	private boolean isValid(UserDto dto) {
		// NullCheck
		// trim
		return true;
	}

}
