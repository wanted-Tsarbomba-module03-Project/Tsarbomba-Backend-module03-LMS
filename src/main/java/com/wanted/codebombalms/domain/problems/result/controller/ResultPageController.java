package com.wanted.codebombalms.domain.problems.result.controller;

import com.wanted.codebombalms.domain.problems.result.dto.response.ProblemSetResultResponse;
import com.wanted.codebombalms.domain.problems.result.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultPageController {

    private final ResultService resultService;

    public ResultPageController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/problem/sets/{problemSetId}/result")
    public String resultPage(
            @PathVariable Long problemSetId,
            @RequestParam(defaultValue = "1") Long userId,
            Model model
    ) {
        ProblemSetResultResponse result = resultService.findResult(problemSetId, userId);

        model.addAttribute("result", result);

        return "problem/result";
    }
}
