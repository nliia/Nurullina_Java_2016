package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.entity.User;

import java.util.List;

public interface RoomService {

    void add(Room room);

    Room findBySenderAndReceiverId(User sender, User receiver);

    List<Room> findAllByUser(User user);

    Room findById(Long id);
}
