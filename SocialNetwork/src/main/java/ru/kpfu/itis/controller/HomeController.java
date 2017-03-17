package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.PostService;
import ru.kpfu.itis.util.PostForm;

@RequestMapping("/home")

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping()
    public String home(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("posts", postService.getByUser(user));
        return "user";
    }

}