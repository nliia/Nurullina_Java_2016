package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Community;

public interface CommunityDao {
    void update(Community community);

    Community findByName(String name);
}
