package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List mostActiveRecipientOfSeason(String season);

    List mostActiveVolunteerOfAddress(String addressRegEx);
}
