package Ch38.Domain.DAO;

import java.sql.SQLException;

import Ch38.Domain.DTO.BookDTO;

public interface BookDao {

	void insert(String a, String b, String c, String d) throws SQLException;

	int insert(BookDTO bookDto) throws Exception;

	int update(BookDTO bookDto) throws Exception;

	int delete(BookDTO bookDto) throws Exception;

	int select(BookDTO bookDto);

}