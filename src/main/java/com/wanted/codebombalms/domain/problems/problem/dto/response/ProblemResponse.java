package com.wanted.codebombalms.domain.problems.problem.dto.response;

import com.wanted.codebombalms.domain.problems.problem.entitiy.Problem;

public record ProblemResponse(
        Long problemId,
        Integer problemNumber,
        String title,
        String content,
        String problemType
) {
    public ProblemResponse(Problem problem) {
        this(
                problem.getProblemId(),
                problem.getProblemOrder(),
                problem.getTitle(),
                problem.getContent(),
                problem.getProblemType()
        );
    }
}
