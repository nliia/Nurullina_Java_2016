package ru.kpfu.itis.dao;

public interface NewsDao {
    void update(String text, Long id);

    int allMessagesByCommunityOfFounder(Long founder_id);
}
