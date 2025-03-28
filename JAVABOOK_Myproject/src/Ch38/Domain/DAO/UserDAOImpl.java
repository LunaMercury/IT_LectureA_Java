// 데이터베이스와 같은 데이터 저장소에 접근하여 데이터를 조작하는 역할을 담당. 데이터베이스와의 연결, 쿼리 실행, 결과 처리 등을 수행.

package Ch38.Domain.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Ch36.Domain.Dto.UserDto;
import Ch38.Domain.DAO.ConnectionPool.ConnectionPool;
import Ch38.Domain.DTO.UserDTO;

public class UserDAOImpl extends DAO implements UserDao {

	// 싱글톤 패턴처리
	private static UserDAOImpl instance;

	private UserDAOImpl() throws ClassNotFoundException, SQLException {
		System.out.println("[DAO] UserDaoImpl init...");
		connectionPool = ConnectionPool.getInstance();
	};

	public static UserDao getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserDAOImpl();
		}
		return instance;
	};

	// CRUD
	@Override
	public int insert(UserDTO userDto) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)"); // DB의 코드
			pstmt.setString(1, userDto.getUserid());
			pstmt.setString(2, userDto.getUsername());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4, "ROLE_USER");

			connectionPool.releaseConnection(connectionItem);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public int update(UserDTO userDto) throws SQLException {

		try {
//			pstmt = conn.prepareStatement(""); // DB의 코드

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's UPDATE SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public int delete(UserDTO userDto) throws SQLException {
		try {
//			pstmt = conn.prepareStatement(""); // DB의 코드

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's DELETE SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	// 단건조회
	@Override
	public UserDto select(UserDTO userDto) {
		return null;
	}

	// 다건조회
	@Override
	public List<UserDto> selectAll() {
		return null;
	}

}
