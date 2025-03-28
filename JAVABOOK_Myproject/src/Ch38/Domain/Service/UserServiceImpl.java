//  UserController에서 호출되어 사용자 관련 비즈니스 로직을 처리. 데이터 유효성 검증, 트랜잭션 관리, 데이터 처리 등을 담당합니다.

package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.DAO.UserDAOImpl;
import Ch38.Domain.DAO.UserDao;
import Ch38.Domain.DAO.ConnectionPool.ConnectionPool;
import Ch38.Domain.DTO.UserDTO;

public class UserServiceImpl {

	//
	private UserDao userDao;
	private ConnectionPool connectionPool;

	// 싱글톤 패턴
	private static UserServiceImpl instance;

	private UserServiceImpl() throws ClassNotFoundException, SQLException {
		userDao = UserDAOImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	};

	public static UserServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	// 회원가입 (+Tx 처리 필요)
	public boolean userJoin(UserDTO userDto) throws Exception {
		boolean isJoin = false;
		try {
			connectionPool.beginTransaction();

			isJoin = userDao.insert(userDto) > 0; // SQL 질의 다수

//			userDao.insert(new UserDTO("aaa", "", "", ""));
//			userDao.insert(new UserDTO("bbb", "", "", ""));
//			userDao.insert(new UserDTO("ccc", "", "", ""));
//			userDao.insert(new UserDTO("aaa", "", "", "")); //PK 중복 오류

			connectionPool.commitTransaction();
		} catch (Exception e) {
			// rollback
			connectionPool.rollbackTransaction();
		}

		return isJoin;

	};

	// 회원조회

	// 회원정보수정

	// 회원탈퇴

	// 로그인

	// 로그아웃

}
