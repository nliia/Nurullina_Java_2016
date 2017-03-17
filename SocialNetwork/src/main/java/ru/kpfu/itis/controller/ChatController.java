package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entity.Message;
import ru.kpfu.itis.entity.Room;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.MessageService;
import ru.kpfu.itis.service.RoomService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.PostForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ChatController {
    private final RoomService roomService;
    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public ChatController(RoomService roomService, MessageService messageService, UserService userService) {
        this.roomService = roomService;
        this.messageService = messageService;
        this.userService = userService;
    }

    @RequestMapping("/chat{userId}")
    public String getChat(@PathVariable Long userId, Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User anotherUser = userService.findById(userId);
        Room room = roomService.findBySenderAndReceiverId(currentUser, anotherUser);
        model.addAttribute("messages", messageService.findAllByRoom(room));
        model.addAttribute("messageForm", new PostForm());
        model.addAttribute("user", anotherUser);
        model.addAttribute("roomId", room.getId());
        return "chat";
    }

    @RequestMapping(value = "/message{roomId}", method = RequestMethod.POST)
    public String sendMessage(@PathVariable Long roomId, @ModelAttribute("message") PostForm postForm, Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        messageService.add(new Message(postForm.getText(), new Date(), roomService.findById(roomId), currentUser));
        System.out.println(currentUser.getId());
        return "redirect:/chat" + currentUser.getId();
    }

    @RequestMapping("/all_chats")
    public String getAllUsers(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Room> chats = roomService.findAllByUser(currentUser);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("chats", chats);
        return "all_chats";
    }
}