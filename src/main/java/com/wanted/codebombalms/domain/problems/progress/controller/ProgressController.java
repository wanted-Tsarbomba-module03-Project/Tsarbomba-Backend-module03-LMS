package com.wanted.codebombalms.domain.problems.progress.controller;

import com.wanted.codebombalms.domain.problems.set.dto.response.SetEnterResponse;
import com.wanted.codebombalms.domain.problems.set.service.ProblemSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgressController {

    private final ProblemSetService problemSetService;

    public ProgressController(ProblemSetService problemSetService) {
        this.problemSetService = problemSetService;
    }

    @GetMapping("/problem/sets/{problemSetId}")
    public String solvePage(
            @PathVariable Long problemSetId,
            @RequestParam(defaultValue = "1") Long userId,
            Model model
    ) {
        SetEnterResponse response =
                problemSetService.enterProblemSet(problemSetId, userId);

        model.addAttribute("problemSet", response);

        return "problem/solve";
    }
}
