package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.Comment;
import ru.kpfu.itis.entity.Post;
import ru.kpfu.itis.repository.CommentRepository;
import ru.kpfu.itis.service.CommentService;

import java.util.List;

@Service
@Transactional

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllByPost(Post post) {
        return commentRepository.findAllByPost(post);
    }
}
