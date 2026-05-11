package com.wanted.codebombalms.domain.problem.category.entity;

import jakarta.persistence.*;

@Entity
public class ProblemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;

    private String description;

    @Column(nullable = false)
    private String status;

    protected ProblemCategory() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
}
