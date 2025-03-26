package Ch37_MVC_Add_View_Socket_Thread;

import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.Criteria;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Service.BookServiceImpl;
import Ch37_MVC_Add_View_Socket_Thread.Socket.ServerBackground;



public class Application {

	public static void main(String[] args) throws Exception {
		
		new ServerBackground().listenServer();
	}
}

