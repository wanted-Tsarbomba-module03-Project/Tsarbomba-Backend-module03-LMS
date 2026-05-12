package com.wanted.codebombalms.domain.problems.submission.entitiy;

import com.wanted.codebombalms.domain.problems.problem.entitiy.Problem;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column(columnDefinition = "TEXT")
    private String submittedAnswer;

    private Boolean isCorrect;

    @Column(nullable = false)
    private Integer earnedScore;

    @Column(nullable = false)
    private Integer attemptNo;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    protected Submission() {
    }

    public Submission(
            Long userId,
            Problem problem,
            String submittedAnswer,
            Boolean isCorrect,
            Integer earnedScore,
            Integer attemptNo
    ) {
        this.userId = userId;
        this.problem = problem;
        this.submittedAnswer = submittedAnswer;
        this.isCorrect = isCorrect;
        this.earnedScore = earnedScore;
        this.attemptNo = attemptNo;
        this.submittedAt = LocalDateTime.now();
    }

    public Long getSubmissionId() {
        return submissionId;
    }

    public Long getUserId() {
        return userId;
    }

    public Problem getProblem() {
        return problem;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public Integer getEarnedScore() {
        return earnedScore;
    }

    public Integer getAttemptNo() {
        return attemptNo;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }


}
