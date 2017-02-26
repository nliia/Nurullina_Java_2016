package ru.kpfu.itis.model;

import ru.kpfu.itis.model.enums.Subject;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Subject subject_type;
    private Integer score;
    private Long student_id;

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Subject getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(Subject subject_type) {
        this.subject_type = subject_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
