package Ch36.Domain.Dao.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDao {
	protected Connection conn =null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	protected ConnectionPool connectionPool;
	
	public CommonDao() throws Exception{
		connectionPool = ConnectionPool.getInstance();
		conn = connectionPool.getConnection();
	}
	
	
	//
	public void freeConnection(Connection conn) throws SQLException {
		 conn.close();
	}
	public void freeConnection(Connection conn,PreparedStatement pstmt) throws SQLException {
		pstmt.close(); 
		conn.close();
	}
	public void freeConnection(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException {
		rs.close();
		pstmt.close();
		conn.close();
	}
	public void freeConnection(PreparedStatement pstmt) throws SQLException {
		pstmt.close(); 
	}
	public void freeConnection(PreparedStatement pstmt,ResultSet rs) throws SQLException {
		rs.close();
		pstmt.close(); 
	}	
}
