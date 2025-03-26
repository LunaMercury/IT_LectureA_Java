package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao.Common.CommonDao;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.PageDto;

public class BookDaoImpl extends CommonDao implements BookDao {
	

	private static BookDao instance ;
	public static BookDao getInstance() throws Exception {
		if(instance==null)
			instance=new BookDaoImpl();
		return instance;
	}
	private BookDaoImpl() throws Exception{
		System.out.println("[DAO] BookDaoImpl's INIT.." + conn);
		
	}
	
	//INSERT
	@Override
	public boolean Insert(BookDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into book values(?,?,?,?)");
		pstmt.setInt(1, dto.getBookCode());
		pstmt.setString(2, dto.getBookName());
		pstmt.setString(3, dto.getPublisher());
		pstmt.setString(4, dto.getIsbn());
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return result>0;
	}
	
	//UPDATE
	//DELETE
	
	//SELECTALL
	@Override
	public List<BookDto> SelectAll() throws Exception{
		pstmt = conn.prepareStatement("select * from book");
		rs =  pstmt.executeQuery();
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new BookDto();
				dto.setBookCode(rs.getInt("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
		}	
		
		
		freeConnection(pstmt,rs);
		return list;
	}
	
	
	//SELECTONE
	@Override
	public BookDto Select(int bookCode) throws Exception {
		pstmt = conn.prepareStatement("select * from book where bookCode=?");
		pstmt.setInt(1, bookCode);
		rs =  pstmt.executeQuery();
		
		BookDto dto = null;
		if(rs!=null)
		{
				rs.next();
				dto = new BookDto();
				dto.setBookCode(rs.getInt("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));		
		}	
		
		freeConnection(pstmt,rs);
		return dto;
	}
	
	
	@Override
	public List<BookDto> SelectAll(Integer pageNo) throws SQLException {
		
		pstmt = conn.prepareStatement("select * from book order by bookCode desc");
		rs =  pstmt.executeQuery();
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new BookDto();
				dto.setBookCode(rs.getInt("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
		}	

		freeConnection(pstmt,rs);
		return list;
	}
	@Override
	public int count() throws Exception {
		
		pstmt = conn.prepareStatement("select count(*) from book");
		rs =  pstmt.executeQuery();
		int count = -1;
		if(rs!=null&&rs.next())
			count = rs.getInt(1);
		freeConnection(pstmt,rs);
		
		return count;
		
	}
	@Override
	public List<BookDto> Select(PageDto pageDto, int offset) throws SQLException {
		
		pstmt = conn.prepareStatement("select * from book order by bookCode desc limit ?,?");
		pstmt.setInt(1, offset);	// 시작 offset
		pstmt.setInt(2, pageDto.getCriteria().getAmount());

		rs =  pstmt.executeQuery();
		
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new BookDto();
				dto.setBookCode(rs.getInt("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
		}	
		
		
		freeConnection(pstmt,rs);
		return list;
	}
	
	
	
		
}
