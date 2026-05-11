package com.wanted.codebombalms.domain.problem.problem.entitiy;

import com.wanted.codebombalms.domain.problem.set.entity.ProblemSet;
import jakarta.persistence.*;

@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemId;

    @ManyToOne
    @JoinColumn(name = "problem_set_id")
    private ProblemSet problemSet;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String problemType;

    private String difficulty;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column(nullable = false)
    private int score;

    private Integer attemptLimit;

    private Boolean isRetriable;

    @Column(nullable = false)
    private String status;

    private Integer problemOrder;

    protected Problem() {
    }

    public Long getProblemId() {
        return problemId;
    }

    public ProblemSet getProblemSet() {
        return problemSet;
    }

    public String getTitle() {
        return title;
    }

    public Integer getProblemOrder() {
        return problemOrder;
    }

    public String getContent() {
        return content;
    }

    public String getProblemType() {
        return problemType;
    }
}
