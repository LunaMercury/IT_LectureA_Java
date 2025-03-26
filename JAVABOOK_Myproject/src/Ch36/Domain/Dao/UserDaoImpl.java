package Ch36.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Ch36.Domain.Dao.Common.CommonDao;
import Ch36.Domain.Dto.SessionDto;
import Ch36.Domain.Dto.UserDto;

public class UserDaoImpl extends CommonDao implements UserDao{

	private static UserDao instance ;
	public static UserDao getInstance() throws Exception {
		if(instance==null)
			instance=new UserDaoImpl();
		return instance;
	}
	
	private UserDaoImpl() throws Exception{
		System.out.println("[DAO] UserDaoImpl's INIT..."+conn);

	}
	
	//INSERT
	@Override
	public boolean Insert(UserDto dto) throws Exception{
		pstmt =  conn.prepareStatement("insert into user values(?,?,?,?)");
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getRole());
		pstmt.setBoolean(4, false);
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result>0;
	}
	
	//UPDATE
	//DELETE
	//SELECTALL
	//SELECT
	
	

	@Override
	public UserDto Select(String username) throws Exception{
		pstmt = conn.prepareStatement("select * from user where username=?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		UserDto dto = null;
		
		if(rs!=null) {
			if(rs.next()) {
				dto = new UserDto();
				dto.setUsername(username);
				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));
				dto.setIslocked(rs.getBoolean("islocked"));
			}
			
		}
		freeConnection(pstmt,rs);
		return dto;	
	}

	
}
