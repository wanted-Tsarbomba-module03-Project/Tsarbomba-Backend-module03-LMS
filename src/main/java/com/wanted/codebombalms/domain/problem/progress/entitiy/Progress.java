package com.wanted.codebombalms.domain.problem.progress.entitiy;

import com.wanted.codebombalms.domain.problem.set.entity.ProblemSet;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "problem_progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "problem_set_id")
    private ProblemSet problemSet;

    @Column(nullable = false)
    private Integer currentProblemNumber;

    private Long lastProblemId;

    @Column(nullable = false)
    private Boolean isCompleted;

    private LocalDateTime completedAt;

    private LocalDateTime updatedAt;

    protected Progress() {
    }

    public Long getProgressId() {
        return progressId;
    }

    public Long getUserId() {
        return userId;
    }

    public ProblemSet getProblemSet() {
        return problemSet;
    }

    public Integer getCurrentProblemNumber() {
        return currentProblemNumber;
    }

    public Long getLastProblemId() {
        return lastProblemId;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
