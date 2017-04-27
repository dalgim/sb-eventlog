package com.dalgim.example.sb.eventlog.mapper;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.model.User;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public class UserMapper {

    public static UserDTO mapToDto(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLogin(user.getLogin());
        userDTO.setId(user.getId());
        return userDTO;
    }

    public static User mapToDomain(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLogin(userDTO.getLogin());
        user.setId(userDTO.getId());
        return user;
    }
}
