package com.dalgim.example.sb.eventlog.logic.usecase;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.architecture.AbstractParamQuery;
import com.dalgim.example.sb.eventlog.logic.service.UserRepository;
import com.dalgim.example.sb.eventlog.mapper.UserMapper;
import com.dalgim.example.sb.eventlog.model.User;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
@RequiredArgsConstructor
public class EditUserParamQuery extends AbstractParamQuery<UserDTO, UserDTO> {

    private final UserRepository userRepository;

    @Override
    public UserDTO logic(UserDTO input) {
        Preconditions.checkNotNull(input, "UserDTO cannot be null!");

        User user = UserMapper.mapToDomain(input);
        User updatedUser = userRepository.update(user);
        return UserMapper.mapToDto(updatedUser);
    }
}
