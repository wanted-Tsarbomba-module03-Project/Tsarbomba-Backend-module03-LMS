package com.wanted.codebombalms.domain.problems.result.dto.response;

import java.util.List;

public record ProblemSetResultResponse(
        Long problemSetId,
        String title,
        Boolean isCompleted,
        Double accuracyRate,
        Integer totalCompletedUserCount,
        Integer correctCompletedUserCount,
        List<ProblemSubmissionResultResponse> submissions
) {
}
