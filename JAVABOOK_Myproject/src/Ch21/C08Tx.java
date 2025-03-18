// Transaction : 개별 실행을 하나로 묶음으로서 모두 실패하던지 모두 성공하던지 처리되게 하는 방법. 

package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C08Tx {
// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC 참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {

		try {
			// DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loading Success");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED");

			//
			System.out.println("INSERT 시작");
			conn.setAutoCommit(false); //이 코드로, 임시테이블에 저장되었다가 오류가 나지 않으면 그때 모두 커밋한다.
			pstmt = conn.prepareStatement("insert into tbl_std values('a', '1', 'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('b', '1', 'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('a', '1', 'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('d', '1', 'a')");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("INSERT 종료");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 오류가 발생했을 때 세이브포인트로 돌려주는 역할. conn이므로 conn에 관련된 모든 함수의 실행 전으로 돌아감. 
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}