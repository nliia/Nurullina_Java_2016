package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.Post;
import ru.kpfu.itis.entity.User;

import java.util.List;

public interface PostService {

    void add(Post post);

    List<Post> getByUser(User author);

    Post get(Long id)
;
}