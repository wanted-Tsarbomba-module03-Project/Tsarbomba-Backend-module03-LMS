package com.wanted.codebombalms.domain.problems.progress.dto.response;

import com.wanted.codebombalms.domain.problems.progress.enums.ProblemProgressStatus;

public record ProblemProgressItemResponse(
        Long problemId,
        Integer problemNumber,
        ProblemProgressStatus status
) {
}
