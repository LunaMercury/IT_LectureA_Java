package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.UserDto;

public interface UserDao {

	//INSERT
	boolean Insert(UserDto dto) throws Exception;

	UserDto Select(String username) throws Exception;

}