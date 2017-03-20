package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.entity.User;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("select r from Room r where r.sender = :sender and r.receiver = :receiver or " +
            "r.sender = :receiver and r.receiver = :sender")
    Room findOneByUsers(@Param("sender") User sender,
                        @Param("receiver") User receiver);

    @Query("select r from Room r where r.receiver =:user or r.sender =:user")
    List<Room> findByUser(@Param("user") User user);
}
