package com.dalgim.example.sb.eventlog;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.AbstractFilteredQuery;
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

	@Test
	public void contextLoads() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		userDTO.setLogin("Johnxxx");
		userDTO.setFirstname("John");
		userEditQuery.execute(userDTO);
	}

}
