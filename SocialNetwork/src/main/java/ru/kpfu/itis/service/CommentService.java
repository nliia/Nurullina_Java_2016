package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.Comment;
import ru.kpfu.itis.entity.Post;

import java.util.List;

public interface CommentService {
    void add(Comment comment);
    List<Comment> getAllByPost(Post post);
}
