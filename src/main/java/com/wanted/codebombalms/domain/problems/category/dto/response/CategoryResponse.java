package com.wanted.codebombalms.domain.problems.category.dto.response;

import com.wanted.codebombalms.domain.problems.category.entity.ProblemCategory;

public record CategoryResponse(
        Long categoryId,
        String categoryName,
        String description
) {
    public CategoryResponse(ProblemCategory category) {
        this(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription()
        );
    }
}
