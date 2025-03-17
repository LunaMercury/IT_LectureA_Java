// select

package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05Select {
	public static void main(String[] args) {
		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";

		// JDBC 참조변수
		Connection conn = null;
		PreparedStatement pstmt = null; // 문장을 미리 만들기 위한
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loading Success");
			// DB연결
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED");

			// SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_std");

			// SQL 실행		
			rs = pstmt.executeQuery(); // select는 executeQuery
			if (rs != null) {
				while (rs.next()) {
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getString("age")+" ");
					System.out.println(rs.getString("addr"));
				}				
			}			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}