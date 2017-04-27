package com.dalgim.example.sb.eventlog;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.AbstractFilteredQuery;
import com.dalgim.example.sb.eventlog.logic.AbstractQuery;
import com.dalgim.example.sb.eventlog.logic.impl.OvervievUserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbEventlogApplicationTests {

	@Autowired
	private AbstractFilteredQuery<UserDTO, UserDTO> userEditQuery;
	@Autowired
	private AbstractQuery<UserDTO> overviewUserQuery;

	@Test
	public void editUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		userDTO.setLogin("Johnxxx");
		userDTO.setFirstname("John");
		userEditQuery.execute(userDTO);
	}

	@Test
	public void overviewUser() throws Exception {
		UserDTO execute = overviewUserQuery.execute();
		assert execute != null;
	}
}
