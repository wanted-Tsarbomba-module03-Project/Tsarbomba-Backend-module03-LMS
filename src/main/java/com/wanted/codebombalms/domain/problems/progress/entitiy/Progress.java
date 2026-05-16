package com.wanted.codebombalms.domain.problems.progress.entitiy;

import com.wanted.codebombalms.domain.problems.set.entity.ProblemSet;
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

    @Column(nullable = false)
    private Boolean isCompleted;

    private LocalDateTime completedAt;

    private LocalDateTime updatedAt;

    protected Progress() {
    }

    public Progress(Long userId, ProblemSet problemSet) {
        this.userId = userId;
        this.problemSet = problemSet;
        this.currentProblemNumber = 1;
        this.isCompleted = false;
        this.completedAt = null;
        this.updatedAt = LocalDateTime.now();
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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void openNextProblem() {
        this.currentProblemNumber = this.currentProblemNumber + 1;
        this.isCompleted = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void complete() {
        this.isCompleted = true;
        this.completedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
