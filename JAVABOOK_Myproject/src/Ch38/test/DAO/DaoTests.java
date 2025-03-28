package Ch38.test.DAO;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Ch38.Domain.DAO.BookDAOImpl;
import Ch38.Domain.DAO.BookDao;
import Ch38.Domain.DAO.UserDAOImpl;
import Ch38.Domain.DAO.UserDao;
import Ch38.Domain.DTO.BookDTO;
import Ch38.Domain.DTO.UserDTO;

class DaoTests {

	@Test
	void test1() throws ClassNotFoundException, SQLException {
		
		UserDao userDaoImpl = UserDAOImpl.getInstance();
	}
	
	@Test
	void test2() throws Exception {
		UserDao userDaoImpl = UserDAOImpl.getInstance();
		userDaoImpl.insert(new UserDTO("aaa", "홍길동", "1234", ""));
	}
	
	@Test
	void test3() throws Exception {
		BookDao bookDaoImpl = BookDAOImpl.getInstance();
		bookDaoImpl.insert(new BookDTO("A", "book1", "john", "1234"));
	}
}
