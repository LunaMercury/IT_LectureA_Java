//데이터베이스 불러오기, 수정, 삭제
// 엑셀(csv 등)으로 되어있는 것을 불러와서 mySQL과 연동해 조작.

package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class ChargeStation {
	private int no;
	private String section;
	private String station;
	private String name;
	private int zipcode;
	private String address;

	// Getter and Setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// toString
	@Override
	public String toString() {
		return "ChargeStation [no=" + no + ", section=" + section + ", station=" + station + ", name=" + name
				+ ", zipcode=" + zipcode + ", address=" + address + "]";
	}

	// 모든 인자 생성자
	public ChargeStation(int no, String section, String station, String name, int zipcode, String address) {
		super();
		this.no = no;
		this.section = section;
		this.station = station;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
	}
}

public class C06Ex extends ChargeStation {
	public C06Ex(int no, String section, String station, String name, int zipcode, String address) {
		super(no, section, station, name, zipcode, address);
	}

	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void connect() throws Exception {
		// DB 연결코드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loading Success");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Select() throws Exception {
		// 전체 조회
		try {
			pstmt = conn.prepareStatement("select * from charge_station");

			// SQL 실행
			rs = pstmt.executeQuery(); // select는 executeQuery
			if (rs != null) {
				while (rs.next()) {
					System.out.print(rs.getString("순번") + " ");
					System.out.print(rs.getString("행정구역") + " ");
					System.out.print(rs.getString("지사") + " ");
					System.out.print(rs.getString("시설명") + " ");
					System.out.print(rs.getString("우편번호") + " ");
					System.out.println(rs.getString("주소") + " ");
				}
			}
			freeConnection(pstmt, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Insert(ChargeStation obj) throws Exception {
		// ChargeStation 객체를 받아 내용 insert

		try {
			pstmt = conn.prepareStatement("insert into charge_station values(?,?,?,?,?,?)");
			pstmt.setInt(1, obj.getNo());
			pstmt.setString(2, obj.getSection());
			pstmt.setString(3, obj.getStation());
			pstmt.setString(4, obj.getName());
			pstmt.setInt(5, obj.getZipcode());
			pstmt.setString(6, obj.getAddress());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
			freeConnection(pstmt);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Update(ChargeStation obj) throws Exception {
		// 수정
		pstmt = conn.prepareStatement("update charge_station set 행정구역=?, 지사=?, 시설명=?, 우편번호=?, 주소=? where 순번=?");
		pstmt.setString(1, obj.getSection());
		pstmt.setString(2, obj.getStation());
		pstmt.setString(3, obj.getName());
		pstmt.setInt(4, obj.getZipcode());
		pstmt.setString(5, obj.getAddress());
		pstmt.setInt(6, obj.getNo());

		int result = pstmt.executeUpdate();
		freeConnection(pstmt);

		if (result > 0)
			System.out.println("UPDATE 성공");
		else
			System.out.println("UPDATE 실패");
	}

	public static void Delete(int a) throws Exception {
		// 삭제
		try {
			pstmt = conn.prepareStatement("delete from charge_station where 순번=?");
			pstmt.setInt(1, a);

			int result = pstmt.executeUpdate();

			if (result > 0)
				System.out.println("UPDATE 성공");
			else
				System.out.println("UPDATE 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 자원제거용 함수 오버로딩
	public static void freeConnection() throws Exception {
		pstmt.close();
		rs.close();
		conn.close();
	}

	public static void freeConnection(Connection conn) throws Exception {
		conn.close();
	}

	public static void freeConnection(PreparedStatement pstmt) throws Exception {
		pstmt.close();
	}

	public static void freeConnection(PreparedStatement pstmt, ResultSet rs) throws Exception {
		pstmt.close();
		rs.close();
	}

	public static void main(String[] args) throws Exception {

		try {
			connect();
//			Insert(new ChargeStation(201, "대구광역시", "대구지사", "대구가스", 10101, "대구"));
//			Delete(201);			
//			Update(new ChargeStation(201, "대구광역시", "중부지사", "대구중부가스", 12345, "대구"));
			Select();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			freeConnection();
		}
	}
}