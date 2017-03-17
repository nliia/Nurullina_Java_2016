package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);

    User findOneById(Long id);
}
