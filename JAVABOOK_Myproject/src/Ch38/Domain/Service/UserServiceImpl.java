//  UserController에서 호출되어 사용자 관련 비즈니스 로직을 처리. 데이터 유효성 검증, 트랜잭션 관리, 데이터 처리 등을 담당합니다.

package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.DAO.UserDAOImpl;
import Ch38.Domain.DTO.UserDTO;

public class UserServiceImpl {

	//
	private UserDAOImpl userDao;

	// 싱글톤 패턴
	private static UserServiceImpl instance;

	private UserServiceImpl() throws ClassNotFoundException, SQLException {
		userDao = UserDAOImpl.getInstance();
		System.out.println("[SERVICE] UserSErviceImpl init...");
	};

	public static UserServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	// 회원가입 (+Tx 처리 필요)
	public boolean userJoin(UserDTO userDto) throws SQLException {
		return userDao.insert(userDto) > 0;

	};

	// 회원조회

	// 회원정보수정

	// 회원탈퇴

	// 로그인

	// 로그아웃

}
