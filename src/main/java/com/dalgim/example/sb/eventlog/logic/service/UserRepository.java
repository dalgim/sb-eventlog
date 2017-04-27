package com.dalgim.example.sb.eventlog.logic.service;

import com.dalgim.example.sb.eventlog.model.User;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public interface UserRepository {

    User findById(Long id);
    User findByLogin(String login);
    User update(User user);
    void delete(User user);
    void deleteById(Long id);
}
