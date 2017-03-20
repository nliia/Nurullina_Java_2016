package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.entity.User;

import java.util.function.Function;

public class UserFormToUserTransformer implements Function<UserForm, User> {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User apply(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        return user;
    }

}
