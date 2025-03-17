// DB에 데이터 삽입

package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C02Insert {

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
			Class.forName("com.mysql.cj.jdbc.Driver"); // 어떤 클래스를 사용할 지 알려주기. 이거 사용하려면 경로설정 해야함
			System.out.println("Driver loading Success");
			// CONNECTION
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED");

			// SQL 쿼리 준비
			// 1. args[]는 run configuration 사용해야함.
//			String name = args[0];
//			int age =Integer.parseInt(args[1]); // 입력은 string으로 들어가서 int 형변환 필요
//			String addr= args[2];
			
			// 2.
			String name = "홍길동";
			int age = 10;
			String addr= "대구";
			
			// 입력			
			// 1.
//			pstmt = conn.prepareStatement("insert into tbl_std values(?,?,?)"); // mySQL 코드를 넣으면 된다.
//			pstmt.setString(1, name);
//			pstmt.setInt(2, age);
//			pstmt.setString(3, addr);
			
			// 2.
//			pstmt = conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')"); // 따옴표에 주의
			
			// 3.
//			pstmt = conn.prepareStatement("insert into tbl_std values("홍길동",10,"대구")");
			
			
			// SQL 실행
			int result = pstmt.executeUpdate();
			if (result>0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}