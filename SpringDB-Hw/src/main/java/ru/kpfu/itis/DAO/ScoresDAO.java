package ru.kpfu.itis.DAO;

import ru.kpfu.itis.model.enums.Subject;

public interface ScoresDAO {
    Long allSubjectsScores(Long studentID);

    Double allSubjectsAverageScore(Long studentID);

    Integer subjectScores(Subject subject, Long studentID);
}
