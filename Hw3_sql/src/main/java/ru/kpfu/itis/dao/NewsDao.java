package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.News;

public interface NewsDao {
    void update(String text, Long id);

    int allMessagesByCommunityOfFounder(Long founder_id);
}
