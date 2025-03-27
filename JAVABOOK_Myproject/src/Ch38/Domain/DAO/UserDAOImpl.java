// 데이터베이스와 같은 데이터 저장소에 접근하여 데이터를 조작하는 역할을 담당. 데이터베이스와의 연결, 쿼리 실행, 결과 처리 등을 수행.

package Ch38.Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch36.Domain.Dto.UserDto;
import Ch38.Domain.DTO.UserDTO;

public class UserDAOImpl {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookDB";

	// 싱글톤 패턴처리
	private static UserDAOImpl instance;

	private UserDAOImpl() throws ClassNotFoundException, SQLException {
		System.out.println("[DAO] UserDaoImpl init...");
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED");
	};

	public static UserDAOImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserDAOImpl();
		}
		return instance;
	};

	// CRUD
	public int insert(UserDTO userDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)"); // DB의 코드
			pstmt.setString(1, userDto.getUserid());
			pstmt.setString(2, userDto.getUsername());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4, "ROLE_USER");

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public int update(UserDTO userDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement(""); // DB의 코드

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

	public int delete(UserDTO userDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement(""); // DB의 코드

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
	public UserDto select(UserDTO userDto) {
		return null;
	}

	// 다건조회
	public List<UserDto> selectAll() {
		return null;
	}
}
