package com.dalgim.example.sb.eventlog.logic.impl;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.AbstractFilteredQuery;
import com.dalgim.example.sb.eventlog.logic.service.UserRepository;
import com.dalgim.example.sb.eventlog.mapper.UserMapper;
import com.dalgim.example.sb.eventlog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
@RequiredArgsConstructor
public class EditUserFilteredQuery extends AbstractFilteredQuery<UserDTO, UserDTO> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO logic(UserDTO input) {
        User user = userMapper.mapToDomain(input);
        User updatedUser = userRepository.update(user);
        return userMapper.mapToDto(updatedUser);
    }
}
