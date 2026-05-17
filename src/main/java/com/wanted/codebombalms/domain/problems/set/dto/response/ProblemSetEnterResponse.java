package com.wanted.codebombalms.domain.problems.set.dto.response;

import com.wanted.codebombalms.domain.problems.problem.dto.response.ProblemResponse;

public record ProblemSetEnterResponse(
        Long problemSetId,
        String title,
        String description,
        Integer currentProblemNumber,
        Boolean isCompleted,
        ProblemResponse problem
) {
}
