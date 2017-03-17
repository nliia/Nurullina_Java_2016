package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.entity.Message;
import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByRoom(Room room);
}
