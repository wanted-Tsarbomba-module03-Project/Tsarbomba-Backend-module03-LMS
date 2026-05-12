package com.wanted.codebombalms.domain.problems.category.dto.response;

import com.wanted.codebombalms.domain.problems.category.entity.ProblemCategory;

public class CategoryResponse {

    private Long categoryId;
    private String categoryName;
    private String description;

    public CategoryResponse(ProblemCategory category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.description = category.getDescription();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }
}
