package Ch38.Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ch38.Domain.DTO.BookDTO;

public class BookDAOImpl {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookDB";

	// 싱글톤 패턴처리
	private static BookDAOImpl instance;

	private BookDAOImpl() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loading Success");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED");
	};

	public static BookDAOImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookDAOImpl();
		}
		return instance;
	};

	public void insert(String a, String b, String c, String d) throws SQLException {
		pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setString(1, a);
		pstmt.setString(2, b);
		pstmt.setString(3, c);
		pstmt.setString(4, d);
		pstmt.executeUpdate();
	}
	public int insert(BookDTO bookDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookDto.getBookCode());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public int update(BookDTO bookDto) throws SQLException {
		try {


			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public int delete(BookDTO bookDto) throws SQLException {
		try {


			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public int select(BookDTO bookDto) {
		return -1;
	}

}
