package Ch36.Domain.Service;

import java.util.List;
import java.util.Map;

import Ch36.Domain.Dto.UserDto;

public interface UserService {

	//회원가입
	boolean UserJoin(UserDto dto) throws Exception;

	//로그인
	Map<String, Object> login(String username, String password, int SessiondId) throws Exception;

	//로그아웃
	Map<String, Object> logout(int SessionId) throws Exception;

	//유저정보 가져오기
	UserDto getUser(String username) throws Exception;

	//현재 접속중인 세션Id list 리턴
	List<Integer> getSessionIdList();

}