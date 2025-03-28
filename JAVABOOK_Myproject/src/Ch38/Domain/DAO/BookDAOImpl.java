package Ch38.Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ch38.Domain.DAO.ConnectionPool.ConnectionItem;
import Ch38.Domain.DAO.ConnectionPool.ConnectionPool;
import Ch38.Domain.DTO.BookDTO;

public class BookDAOImpl extends DAO implements BookDao {

	// 싱글톤 패턴처리
	private static BookDao instance;

	private BookDAOImpl() throws ClassNotFoundException, SQLException {
		System.out.println("[DAO] BookDaoImpl init....");
		connectionPool = ConnectionPool.getInstance();
	};

	public static BookDao getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookDAOImpl();
		}
		return instance;
	};

	// CRUD
	@Override
	public int insert(BookDTO bookDto) throws SQLException {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookDto.getBookCode());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());

			connectionPool.releaseConnection(connectionItem);

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

	@Override
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

	@Override
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

	@Override
	public int select(BookDTO bookDto) {
		return -1;
	}

	@Override
	public void insert(String a, String b, String c, String d) throws SQLException {
		// TODO Auto-generated method stub

	}

}
