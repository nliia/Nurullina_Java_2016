package ru.kpfu.itis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.kpfu.itis.model.enums.Subject;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "subjectType")
    private Subject subjectType;

    private Integer score;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Subject getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Subject subjectType) {
        this.subjectType = subjectType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
