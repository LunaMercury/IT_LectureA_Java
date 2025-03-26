package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao;

import java.util.ArrayList;
import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao.Common.CommonDao;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.SessionDto;

public class SessionDaoImpl extends CommonDao implements SessionDao{

	private static SessionDao instance ;
	public static SessionDao getInstance() throws Exception {
		if(instance==null)
			instance=new SessionDaoImpl();
		return instance;
	}
	
	private SessionDaoImpl() throws Exception{
		System.out.println("[DAO] SessionDaoImpl's INIT "+conn);

	}
	
	//SESSION용
	@Override
	public boolean Insert(SessionDto sessionDto) throws Exception {
		pstmt =  conn.prepareStatement("insert into session values(null,?,?)");
		pstmt.setString(1, sessionDto.getUsername());
		pstmt.setString(2, sessionDto.getRole());
		return pstmt.executeUpdate()>0;
	}
	
	@Override
	public SessionDto Select(int sessiondId) throws Exception {
		pstmt = conn.prepareStatement("select * from session where id=?");
		pstmt.setInt(1,sessiondId);
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
		}
			
		freeConnection(pstmt,rs);
		return dto;
	}
	@Override
	public SessionDto Select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username=? order by id desc");
		pstmt.setString(1,username);
		
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
		}
		freeConnection(pstmt,rs);
		return dto;
	}

	@Override
	public boolean Delete(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("delete from session where id=?");
		pstmt.setInt(1, sessionId);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return  result>0;
	}
	
	//SELECTALL
	@Override
	public List<SessionDto> SelectAll() throws Exception{
		pstmt = conn.prepareStatement("select * from session");
		rs =  pstmt.executeQuery();
		List<SessionDto> list = new ArrayList();
		SessionDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new SessionDto();
				dto.setUsername(rs.getString("username"));
				dto.setSessionId(rs.getInt("id"));
				dto.setRole(rs.getString("role"));
				list.add(dto);
			}
		}	
		freeConnection(pstmt,rs);
		return list;
	}
	
	
}
