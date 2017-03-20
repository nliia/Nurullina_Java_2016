package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.entity.Comment;
import ru.kpfu.itis.entity.Post;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.CommentService;
import ru.kpfu.itis.service.PostService;
import ru.kpfu.itis.service.UserService;

import java.util.Date;

@Controller
public class PostController {

    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, CommentService commentService, UserService userService) {
        this.postService = postService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @RequestMapping("/post{id}")
    public String getPostPage(@PathVariable Long id, Model model) {

        Post post = postService.get(id);
        model.addAttribute(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getAllByPost(post));
        model.addAttribute("userSession", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post";
    }

    @RequestMapping(value = "id{id}/post", method = RequestMethod.POST)
    public String addPost(@PathVariable Long id,
                          @RequestParam("post") String post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.add(new Post(post, new Date(), user, userService.findById(id)));

        return "redirect:/id" + id;
    }

    @RequestMapping(value = "/post{id}", method = RequestMethod.POST)
    public String addComment(@PathVariable Long id,
                             @RequestParam("comment") String comment) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.add(new Comment(comment, user, postService.get(id), new Date()));
        return "redirect:/post" + id;
    }
}
