package Ch36.Domain.Dao;

import java.util.List;

import Ch36.Domain.Dto.BookDto;

public interface BookDao {

	//INSERT
	boolean Insert(BookDto dto) throws Exception;

	//SELECTALL
	List<BookDto> SelectAll() throws Exception;

	//SELECTONE
	BookDto Select(int bookCode) throws Exception;

}