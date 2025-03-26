package Ch36.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Ch36.Domain.Dao.Common.CommonDao;
import Ch36.Domain.Dto.BookDto;




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
	
	
	
		
}
