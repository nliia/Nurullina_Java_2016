package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.service.PostService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.PostForm;

@Controller
@RequestMapping("/id{id}")
public class UserController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public UserController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping
    public String getPage(@PathVariable Long id, Model model) {

        model.addAttribute("user", userService.findById(id));
        model.addAttribute("posts", postService.getByUser(userService.findById(id)));
        model.addAttribute("postForm", new PostForm());
        return "user";
    }
}
