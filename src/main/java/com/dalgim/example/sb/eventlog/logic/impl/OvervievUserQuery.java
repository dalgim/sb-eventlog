package com.dalgim.example.sb.eventlog.logic.impl;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.Query;
import com.dalgim.example.sb.eventlog.logic.service.UserDetailService;
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
public class OvervievUserQuery implements Query<UserDTO> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailService userDetailService;

    @Override
    public UserDTO execute() {
        User user = userRepository.findById(userDetailService.getUserId());
        return userMapper.mapToDto(user);
    }
}
