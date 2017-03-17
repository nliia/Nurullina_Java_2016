package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/friends")
public class FriendsController {
    private final UserService userService;

    @Autowired
    public FriendsController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String getFriendsPage(Model model) {
        List<User> users = new ArrayList<User>();
        users = userService.getAll();
        users.remove(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("users", users);
        return "friends";
    }
}
