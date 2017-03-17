package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @Override
    public User findOneByEmail(String email) {
      return   userRepository.findOneByEmail(email);
    }

    @Override
    public User findById(Long id) {
      return   userRepository.findOne(id);
    }
}
