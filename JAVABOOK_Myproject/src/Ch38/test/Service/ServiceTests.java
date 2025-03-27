package Ch38.test.Service;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Domain.DTO.UserDTO;
import Ch38.Domain.Service.UserServiceImpl;

class ServiceTests {

	@Test
	@Disabled
	void test1() throws SQLException, ClassNotFoundException {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.userJoin(new UserDTO("bbb", "남길동", "1234", "ROLE_USER"));
	}

	@Test
	@Disabled
	void test2() {

	}

}
