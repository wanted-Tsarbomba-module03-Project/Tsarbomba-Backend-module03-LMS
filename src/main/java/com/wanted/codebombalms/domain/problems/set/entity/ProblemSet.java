package com.wanted.codebombalms.domain.problems.set.entity;

import com.wanted.codebombalms.domain.problems.category.entity.ProblemCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProblemSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemSetId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProblemCategory category;

    @Column(nullable = false)
    private String title;

    private String description;

    private String difficulty;

    @Column(nullable = false)
    private String status;

    private LocalDateTime createdAt;

    protected ProblemSet() {
    }

    public Long getProblemSetId() {
        return problemSetId;
    }

    public ProblemCategory getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
