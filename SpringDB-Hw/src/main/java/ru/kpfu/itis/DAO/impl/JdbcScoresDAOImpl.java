package ru.kpfu.itis.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.DAO.ScoresDAO;
import ru.kpfu.itis.model.enums.Subject;

@Service
public class JdbcScoresDAOImpl implements ScoresDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long allSubjectsScores(Long studentID) {
        return jdbcTemplate.queryForObject("SELECT sum(score) FROM scores WHERE student_id=" + studentID, Long.class);
    }

    public Double allSubjectsAverageScore(Long studentID) {
        return jdbcTemplate.queryForObject("SELECT avg(score) FROM scores WHERE student_id=" + studentID, Double.class);
    }

    public Integer subjectScores(Subject subject, Long studentID) {
        return jdbcTemplate.queryForObject("SELECT score FROM scores WHERE student_id=" + studentID + " AND subject_type=" + "'" + subject.toString().toLowerCase() + "'", Integer.class);
    }
}
