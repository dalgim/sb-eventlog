package com.dalgim.example.sb.eventlog.logic.service.impl;

import com.dalgim.example.sb.eventlog.logic.service.UserRepository;
import com.dalgim.example.sb.eventlog.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
public class UserRepositoryImpl implements UserRepository {

    private static List<User> userList = new ArrayList<>();

    static {
        User user = new User();
        user.setLogin("John.Smith");
        user.setFirstname("John");
        user.setId(1L);
        userList.add(user);
    }

    @Override
    public User findById(Long id) {
        return userList.stream().filter(user -> Objects.equals(id, user.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User update(User updatedUser) {
        User user = findById(updatedUser.getId());
        if (user != null) {
            user.setFirstname(updatedUser.getFirstname());
            user.setLogin(updatedUser.getLogin());
        }
        return user;
    }

    @Override
    public void delete(User user) {
        userList.remove(user);
    }
}
