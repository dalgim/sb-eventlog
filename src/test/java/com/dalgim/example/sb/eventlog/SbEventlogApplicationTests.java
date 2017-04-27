package com.dalgim.example.sb.eventlog;

import com.dalgim.example.sb.eventlog.dto.DeleteUserDTO;
import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.architecture.AbstractCommand;
import com.dalgim.example.sb.eventlog.logic.architecture.AbstractParamQuery;
import com.dalgim.example.sb.eventlog.logic.architecture.AbstractQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbEventlogApplicationTests {

	@Autowired
	private AbstractParamQuery<UserDTO, UserDTO> userEditQuery;
	@Autowired
	private AbstractQuery<UserDTO> overviewUserQuery;
	@Autowired
	private AbstractCommand<DeleteUserDTO> deleteUserCommand;

	@Test
	public void editUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		userDTO.setLogin("Johnxxx");
		userDTO.setFirstName("John");
		userEditQuery.execute(userDTO);
	}

	@Test
	public void overviewUser() throws Exception {
		UserDTO execute = overviewUserQuery.execute();
		assert execute != null;
	}

	@Test
	public void deleteUser() throws Exception {

		DeleteUserDTO deleteUserDTO = new DeleteUserDTO();
		deleteUserDTO.setId(1L);
		deleteUserCommand.execute(deleteUserDTO);
	}
}
