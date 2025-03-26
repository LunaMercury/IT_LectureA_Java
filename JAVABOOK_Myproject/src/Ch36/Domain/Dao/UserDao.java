package Ch36.Domain.Dao;

import Ch36.Domain.Dto.UserDto;

public interface UserDao {

	//INSERT
	boolean Insert(UserDto dto) throws Exception;

	UserDto Select(String username) throws Exception;

}