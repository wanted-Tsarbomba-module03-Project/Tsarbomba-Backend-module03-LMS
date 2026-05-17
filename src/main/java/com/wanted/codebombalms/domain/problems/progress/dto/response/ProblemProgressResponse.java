package com.wanted.codebombalms.domain.problems.progress.dto.response;

import java.util.List;

public record ProblemProgressResponse(
        Long problemSetId,
        Integer totalProblemCount,
        Integer currentProblemNumber,
        Long currentProblemId,
        Integer solvedProblemCount,
        List<ProblemProgressItemResponse> problems
) {
}