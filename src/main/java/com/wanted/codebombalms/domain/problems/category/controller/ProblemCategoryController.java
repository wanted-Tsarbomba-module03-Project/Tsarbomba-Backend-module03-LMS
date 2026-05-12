package com.wanted.codebombalms.domain.problems.category.controller;

import com.wanted.codebombalms.domain.problems.category.dto.response.CategoryResponse;
import com.wanted.codebombalms.domain.problems.category.service.ProblemCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/problem-categories")
public class ProblemCategoryController {

    private final ProblemCategoryService problemCategoryService;

    public ProblemCategoryController(ProblemCategoryService problemCategoryService) {
        this.problemCategoryService = problemCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findCategories() {
        return ResponseEntity.ok(problemCategoryService.findActiveCategories());
    }
}
