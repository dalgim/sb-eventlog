package com.dalgim.example.sb.eventlog.logic.usecase;

import com.dalgim.example.sb.eventlog.dto.DeleteUserDTO;
import com.dalgim.example.sb.eventlog.logic.architecture.AbstractCommand;
import com.dalgim.example.sb.eventlog.logic.service.UserRepository;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
@RequiredArgsConstructor
public class DeleteUserCommand extends AbstractCommand<DeleteUserDTO> {

    private final UserRepository userRepository;

    @Override
    public void logic(DeleteUserDTO input) {
        Preconditions.checkNotNull(input, "DeleteUserDTO cannot be null!");

        userRepository.deleteById(input.getId());
    }
}
