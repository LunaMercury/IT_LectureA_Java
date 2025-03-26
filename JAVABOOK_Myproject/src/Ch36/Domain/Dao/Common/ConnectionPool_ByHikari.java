package Ch36.Domain.Dao.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import Ch36.Properties.CommonProperties;

public class ConnectionPool_ByHikari {


//	protected String url ="jdbc:mysql://localhost:3306/bookdb";
//	protected String id = "root";
//	protected String pw = "1234";

	//05-03 application.properties
	protected Connection conn =null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	
	//05-02 Hikari
	private HikariDataSource dataSource;
	
	private static ConnectionPool_ByHikari instance ;
	public static ConnectionPool_ByHikari getInstance() throws Exception {
		if(instance==null)
			instance=new ConnectionPool_ByHikari();
		return instance;
	}
	

	private ConnectionPool_ByHikari() throws Exception{
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
		
		//---------------------
		//05-02 Hikari
		//---------------------
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		config.setJdbcUrl(url);
//		config.setUsername(id);
//		config.setPassword(pw);
		
		//05-03
		config.setJdbcUrl(CommonProperties.DBURL);
		config.setUsername(CommonProperties.DBID);
		config.setPassword(CommonProperties.DBPW);	
		//최대 Connection 개수
		config.setMaximumPoolSize(10);

		this.dataSource = new HikariDataSource(config);
		//---------------------

		this.conn = dataSource.getConnection();
		System.out.println("Hikari ConnectionPool's DB get..." + conn);
		
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}
	
	
	
	//05-01 TX
	public void txStart() throws SQLException {
		conn.setAutoCommit(false);	
	}
	//05-01 TX
	public void txCommit() throws SQLException {
		conn.commit();
	}
	//05-01 TX
	public void txRollBack() throws SQLException {
		conn.rollback();
	}
	
	
}
