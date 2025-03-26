package Ch36.Domain.Service;

import java.util.List;

import Ch36.Domain.Dto.BookDto;

public interface BookService {

	boolean bookRegister(BookDto dto) throws Exception;

	List<BookDto> getAllBooks() throws Exception;

	BookDto getBook(int bookCode) throws Exception;

}