package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.DAO.ScoresDAO;
import ru.kpfu.itis.DAO.impl.JdbcScoresDAOImpl;
import ru.kpfu.itis.model.Scores;
import ru.kpfu.itis.model.enums.Subject;
import ru.kpfu.itis.repository.ScoresRepository;

@Controller
public class MainController {

    private final JdbcScoresDAOImpl jdbcScoresDAOImpl;
    private final ScoresDAO entityManagerDAO;
    private final ScoresRepository scoresRepository;
//    @Autowired
//    ScoresRepository scoresRepository;


    @Autowired
    public MainController(ScoresRepository scoresRepository, JdbcScoresDAOImpl jdbcScoresDAOImpl, @Qualifier("entityManagerScoresDAOImpl") ScoresDAO entityManagerDAO) {
        this.scoresRepository = scoresRepository;
        this.jdbcScoresDAOImpl = jdbcScoresDAOImpl;
        this.entityManagerDAO = entityManagerDAO;
    }

    @RequestMapping("/home")
    @ResponseBody
    public Scores home() {
        return scoresRepository.findOne(Long.valueOf(1));
//        return "avg: " + entityManagerDAO.allSubjectsAverageScore(Long.valueOf(1)) +
//                " sum: " + entityManagerDAO.allSubjectsScores(Long.valueOf(1)) +
//                " liter: " + entityManagerDAO.subjectScores(Subject.LITERATURE, Long.valueOf(1));

//        return "avg: " + jdbcScoresDAOImpl.allSubjectsAverageScore(Long.valueOf(1)).toString() +
//                " sum: " + jdbcScoresDAOImpl.allSubjectsScores(Long.valueOf(1)).toString() +
//                " subject's score:" + jdbcScoresDAOImpl.subjectScores(Subject.LITERATURE, Long.valueOf(1)).toString();

    }

}