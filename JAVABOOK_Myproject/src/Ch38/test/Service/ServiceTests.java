package Ch38.test.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Domain.DTO.BookDTO;
import Ch38.Domain.DTO.UserDTO;
import Ch38.Domain.Service.BookServiceImpl;
import Ch38.Domain.Service.UserServiceImpl;

class ServiceTests {

	@Test
	@Disabled
	void test1() throws Exception {
		UserServiceImpl userService = UserServiceImpl.getInstance();
//		userService.userJoin(null);
		userService.userJoin(new UserDTO("bbb", "남길동", "1234", "ROLE_USER"));
	}

	@Test
//	@Disabled
	void test2() throws Exception {
		BookServiceImpl bookService =BookServiceImpl.getInstance();
		bookService.bookRegistration(new BookDTO("12345678", "C언어기본", "코리아미디어", "1010-1010"));
	}

}
