package com.wanted.codebombalms.domain.problems.progress.controller;

import com.wanted.codebombalms.domain.problems.progress.dto.response.ProblemProgressResponse;
import com.wanted.codebombalms.domain.problems.progress.service.ProgressService;
import com.wanted.codebombalms.domain.problems.set.dto.response.ProblemSetEnterResponse;
import com.wanted.codebombalms.domain.problems.set.service.ProblemSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgressController {

    private final ProblemSetService problemSetService;
    private final ProgressService progressService;

    public ProgressController(ProblemSetService problemSetService, ProgressService progressService) {
        this.problemSetService = problemSetService;
        this.progressService = progressService;
    }

    @GetMapping("/problem/sets/{problemSetId}")
    public String solvePage(
            @PathVariable Long problemSetId,
            @RequestParam(defaultValue = "1") Long userId,
            Model model
    ) {
        ProblemSetEnterResponse response =
                problemSetService.enterProblemSet(problemSetId, userId);

        if (Boolean.TRUE.equals(response.isCompleted())) {
            return "redirect:/problem/sets/" + problemSetId + "/result?userId=" + userId;
        }

        ProblemProgressResponse progress =
                progressService.findProblemSetProgress(problemSetId, userId);

        model.addAttribute("problemSet", response);
        model.addAttribute("progress", progress);

        return "problem/solve";
    }
}
