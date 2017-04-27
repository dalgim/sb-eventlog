package com.dalgim.example.sb.eventlog.logic.service;

import com.dalgim.example.sb.eventlog.logic.service.UserDetailService;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
public class MockUserDetailService implements UserDetailService {
    @Override
    public Long getUserId() {
        return 1L;
    }
}
