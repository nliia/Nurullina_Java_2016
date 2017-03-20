package ru.kpfu.itis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.repository.RoomRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.RoomService;

import java.util.List;

@Service
@Transactional

public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final UserRepository userService;

    public RoomServiceImpl(RoomRepository roomRepository, UserRepository userService) {
        this.roomRepository = roomRepository;
        this.userService = userService;
    }

    @Override
    public void add(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room findBySenderAndReceiverId(User sender, User receiver) {
        Room room = roomRepository.findOneByUsers(sender, receiver);
        if ( room!= null)
            return room;
        else
            return roomRepository.save(new Room(userService.findOne(sender.getId()),
                    userService.findOne(receiver.getId())));
    }

    @Override
    public List<Room> findAllByUser(User user) {
        return roomRepository.findByUser(user);
    }


    @Override
    public Room findById(Long id) {
        return roomRepository.findOne(id);
    }

}
