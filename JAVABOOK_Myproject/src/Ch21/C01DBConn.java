// JDBC란? Java 와 DB의 Connection.

package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.checkerframework.common.reflection.qual.ForName;

public class C01DBConn {

	public static void main(String[] args) {
		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		// JDBC 참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 어떤 클래스를 사용할 지 알려주기. 이거 사용하려면 경로설정 해야함
			System.out.println("Driver loading Success");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}