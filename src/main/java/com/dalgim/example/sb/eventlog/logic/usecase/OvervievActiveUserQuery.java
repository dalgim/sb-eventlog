package com.dalgim.example.sb.eventlog.logic.usecase;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.architecture.AbstractQuery;
import com.dalgim.example.sb.eventlog.logic.service.UserContextService;
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
public class OvervievActiveUserQuery extends AbstractQuery<UserDTO> {

    private final UserRepository userRepository;
    private final UserContextService userContextService;

    @Override
    public UserDTO logic() {
        String activeUserLogin = userContextService.getActiveUserLogin();
        User user = userRepository.findByLogin(activeUserLogin);
        return UserMapper.mapToDto(user);
    }
}
