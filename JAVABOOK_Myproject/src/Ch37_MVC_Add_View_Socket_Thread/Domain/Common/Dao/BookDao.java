package Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.BookDto;
import Ch37_MVC_Add_View_Socket_Thread.Domain.Common.Dto.PageDto;



public interface BookDao {

	//INSERT
	boolean Insert(BookDto dto) throws Exception;

	//SELECTALL
	List<BookDto> SelectAll() throws Exception;

	//SELECTONE
	BookDto Select(int bookCode) throws Exception;

	List<BookDto> SelectAll(Integer pageNo) throws SQLException;
	
	//COUNT
	int count() throws Exception;

	List<BookDto> Select(PageDto pageDto, int offset) throws SQLException;

}