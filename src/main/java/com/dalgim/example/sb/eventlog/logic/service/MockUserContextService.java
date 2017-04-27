package com.dalgim.example.sb.eventlog.logic.service;

import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
public class MockUserContextService implements UserContextService {

    @Override
    public String getActiveUserLogin() {
        return "John.Smith";
    }
}
