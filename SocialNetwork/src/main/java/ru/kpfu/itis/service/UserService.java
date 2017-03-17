package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> getAll();

    User findOneByEmail(String email);
    User findById(Long id);

}
