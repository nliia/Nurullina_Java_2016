package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.Message;
import ru.kpfu.itis.entity.Room;

import java.util.List;

public interface MessageService {
    void add(Message message);

    List<Message> findAllByRoom(Room room);
}
