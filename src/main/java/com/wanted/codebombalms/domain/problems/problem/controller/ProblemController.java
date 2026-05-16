package com.wanted.codebombalms.domain.problems.problem.controller;

import com.wanted.codebombalms.domain.problems.category.dto.response.CategoryResponse;
import com.wanted.codebombalms.domain.problems.category.service.ProblemCategoryService;
import com.wanted.codebombalms.domain.problems.set.dto.response.SetResponse;
import com.wanted.codebombalms.domain.problems.set.service.ProblemSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProblemController {

    private final ProblemCategoryService problemCategoryService;
    private final ProblemSetService problemSetService;

    public ProblemController(
            ProblemCategoryService problemCategoryService,
            ProblemSetService problemSetService
    ) {
        this.problemCategoryService = problemCategoryService;
        this.problemSetService = problemSetService;
    }

    @GetMapping("/problem")
    public String problemList(
            @RequestParam(required = false) Long categoryId,
            Model model
    ) {
        List<CategoryResponse> categories = problemCategoryService.findActiveCategories();

        Long selectedCategoryId = categoryId;

        if (selectedCategoryId == null && !categories.isEmpty()) {
            selectedCategoryId = categories.get(0).categoryId();
        }

        List<SetResponse> problemSets = List.of();

        if (selectedCategoryId != null) {
            problemSets = problemSetService.findActiveSetsByCategory(selectedCategoryId);
        }

        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategoryId", selectedCategoryId);
        model.addAttribute("problemSets", problemSets);

        return "problem/list";
    }
}
