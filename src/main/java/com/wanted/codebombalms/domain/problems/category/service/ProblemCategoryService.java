package com.wanted.codebombalms.domain.problems.category.service;

import com.wanted.codebombalms.domain.problems.category.dto.response.CategoryResponse;
import com.wanted.codebombalms.domain.problems.category.repository.ProblemCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemCategoryService {

    private final ProblemCategoryRepository problemCategoryRepository;

    public ProblemCategoryService(ProblemCategoryRepository problemCategoryRepository) {
        this.problemCategoryRepository = problemCategoryRepository;
    }

    public List<CategoryResponse> findActiveCategories() {
        return problemCategoryRepository.findByStatusOrderByCategoryIdAsc("ACTIVE")
                .stream()
                .map(CategoryResponse::new)
                .toList();
    }

    public boolean existsActiveCategory(Long categoryId) {
        return problemCategoryRepository.existsByCategoryIdAndStatus(categoryId, "ACTIVE");
    }
}
