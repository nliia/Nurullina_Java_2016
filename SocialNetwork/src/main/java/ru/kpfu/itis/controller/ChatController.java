package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.entity.Message;
import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.MessageService;
import ru.kpfu.itis.service.RoomService;
import ru.kpfu.itis.service.UserService;

import java.util.Date;
import java.util.List;

@Controller
public class ChatController {
    private final RoomService roomService;
    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public ChatController(RoomService roomService,
                          MessageService messageService,
                          UserService userService) {
        this.roomService = roomService;
        this.messageService = messageService;
        this.userService = userService;
    }

    @RequestMapping("/chat{userId}")
    public String getChat(@PathVariable Long userId, Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User anotherUser = userService.findById(userId);
        Room room = roomService.findBySenderAndReceiverId(currentUser, anotherUser);
        List<Message> messages = messageService.findAllByRoom(room);
        model.addAttribute("messages", messages);
        model.addAttribute("user", anotherUser);
        model.addAttribute("roomId", room.getId());
        model.addAttribute("userSession", currentUser);
        return "chat";
    }

    @RequestMapping(value = "/message{roomId}", method = RequestMethod.POST)
    public String sendMessage(@PathVariable Long roomId,
                              @RequestParam("message") String message,
                              @RequestParam(name = "userId") Long userId) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        messageService.add(new Message(message, new Date(), roomService.findById(roomId), currentUser));
        return "redirect:/chat" + userId;
    }

    @RequestMapping("/all_chats")
    public String getAllUsers(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Room> chats = roomService.findAllByUser(currentUser);
        model.addAttribute("userSession", currentUser);
        model.addAttribute("chats", chats);
        return "all_chats";
    }
}
