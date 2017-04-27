package com.dalgim.example.sb.eventlog.mapper;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Component
public class UserMapper {

    public UserDTO mapToDto(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLogin(user.getLogin());
        userDTO.setId(user.getId());
        return userDTO;
    }

    public User mapToDomain(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLogin(userDTO.getLogin());
        user.setId(userDTO.getId());
        return user;
    }
}
