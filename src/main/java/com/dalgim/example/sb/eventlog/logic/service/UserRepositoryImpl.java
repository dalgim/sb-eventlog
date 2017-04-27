package com.dalgim.example.sb.eventlog.logic.service;

import com.dalgim.example.sb.eventlog.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
public class UserRepositoryImpl implements UserRepository {

    private static List<User> userList = Lists.newArrayList();

    static {
        User user = new User();
        user.setLogin("John.Smith");
        user.setFirstName("John");
        user.setId(1L);
        userList.add(user);
    }

    @Override
    public User findById(Long id) {
        Preconditions.checkNotNull(id, "User ID cannot be null!");

        return userList.stream().filter(user -> Objects.equals(id, user.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        Preconditions.checkNotNull(login, "User LOGIN cannot be null!");

        return userList.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User update(User updatedUser) {
        Preconditions.checkNotNull(updatedUser, "Updated USER cannot be null!");

        User user = findById(updatedUser.getId());
        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLogin(updatedUser.getLogin());
        }
        return user;
    }

    @Override
    public void delete(User user) {
        Preconditions.checkNotNull(user, "Deleted USER cannot be null!");

        userList.remove(user);
    }

    @Override
    public void deleteById(Long id) {
        Preconditions.checkNotNull("Deleted USER ID cannot be null!");

        User user = findById(id);
        if (user != null) {
            userList.remove(user);
        }
    }
}
