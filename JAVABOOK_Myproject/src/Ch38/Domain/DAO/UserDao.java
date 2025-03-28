package Ch38.Domain.DAO;

import java.util.List;

import Ch36.Domain.Dto.UserDto;
import Ch38.Domain.DTO.UserDTO;

public interface UserDao {

	// CRUD
	int insert(UserDTO userDto) throws Exception;

	int update(UserDTO userDto) throws Exception;

	int delete(UserDTO userDto) throws Exception;

	// 단건조회
	UserDto select(UserDTO userDto);

	// 다건조회
	List<UserDto> selectAll();

}