package com.wanted.codebombalms.domain.problem.set.entity;

import com.wanted.codebombalms.domain.problem.category.entity.ProblemCategory;
import jakarta.persistence.*;

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
}
