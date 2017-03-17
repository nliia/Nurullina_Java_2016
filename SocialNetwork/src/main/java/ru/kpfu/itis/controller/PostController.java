package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.entity.Comment;
import ru.kpfu.itis.entity.Post;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.service.CommentService;
import ru.kpfu.itis.service.PostService;
import ru.kpfu.itis.util.CommentForm;
import ru.kpfu.itis.util.PostForm;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @RequestMapping("/post{id}")
    public String getPostPage(@PathVariable Long id, Model model) {

        Post post = postService.get(id);
        model.addAttribute(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getAllByPost(post));
        return "post";
    }

    @RequestMapping(value = "id{id}/post", method = RequestMethod.POST)
    public String addPost(@PathVariable Long id, @ModelAttribute("postForm") @Valid PostForm postForm) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.add(new Post(postForm.getText(), new Date(), user));

        return "redirect:/id" + id;
    }

    @RequestMapping(value = "/post{id}", method = RequestMethod.POST)
    public String addComment(@PathVariable Long id, @ModelAttribute("commentForm") @Valid CommentForm commentForm) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.add(new Comment(commentForm.getText(), user, postService.get(id), new Date()));
        return "redirect:/post" + id;
    }
}
