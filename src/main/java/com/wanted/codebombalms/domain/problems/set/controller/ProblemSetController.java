package com.wanted.codebombalms.domain.problems.set.controller;

import com.wanted.codebombalms.domain.problems.set.dto.response.SetEnterResponse;
import com.wanted.codebombalms.domain.problems.set.dto.response.SetResponse;
import com.wanted.codebombalms.domain.problems.set.service.ProblemSetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProblemSetController {

    private final ProblemSetService problemSetService;

    public ProblemSetController(ProblemSetService problemSetService) {
        this.problemSetService = problemSetService;
    }

    @GetMapping("/api/v1/problem-sets")
    public ResponseEntity<List<SetResponse>> findProblemSets(
            @RequestParam Long categoryId
    ) {
        return ResponseEntity.ok(problemSetService.findActiveSetsByCategory(categoryId));
    }
    @PostMapping("/api/v1/problem-sets/{id}")
    public ResponseEntity<SetEnterResponse> enterProblemSet(
            @PathVariable Long id,
            @RequestParam Long userId
    ) {
        return ResponseEntity.ok(problemSetService.enterProblemSet(id, userId));
    }
}
