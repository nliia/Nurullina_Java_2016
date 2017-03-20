package ru.kpfu.itis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.Message;
import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.repository.MessageRepository;
import ru.kpfu.itis.service.MessageService;

import java.util.List;

@Service
@Transactional

public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void add(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> findAllByRoom(Room room) {
       return messageRepository.findAllByRoom(room);
    }
}
