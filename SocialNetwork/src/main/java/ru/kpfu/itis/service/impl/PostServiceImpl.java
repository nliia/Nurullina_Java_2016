package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.Post;
import ru.kpfu.itis.entity.User;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.service.PostService;

import java.util.List;

@Service
@Transactional

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public void add(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getByUser(User author) {
        return postRepository.findAllByAuthor(author);
    }

    @Override
    public Post get(Long id) {
        return postRepository.findOne(id);
    }
}
