package ru.kpfu.itis.DAO.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.DAO.ScoresDAO;
import ru.kpfu.itis.model.enums.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class EntityManagerScoresDAOImpl implements ScoresDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManagerScoresDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Long allSubjectsScores(Long studentID) {
        return entityManager.createQuery(
                "SELECT sum(score) FROM Scores WHERE student_id= ?1", Long.class)
                .setParameter(1, studentID)
                .getSingleResult();
    }

    @Override
    public Double allSubjectsAverageScore(Long studentID) {
        return entityManager.createQuery(
                "SELECT avg(score) FROM Scores WHERE student_id= ?1", Double.class)
                .setParameter(1, studentID)
                .getSingleResult();
    }

    @Override
    public Integer subjectScores(Subject subject, Long studentID) {
        return entityManager.createQuery(
                "SELECT score FROM Scores WHERE student_id= ?1", Integer.class)
                .setParameter(1, studentID)
                .getSingleResult();
    }

}
