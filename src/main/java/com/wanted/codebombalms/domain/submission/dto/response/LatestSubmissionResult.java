package com.wanted.codebombalms.domain.submission.dto.response;

public record LatestSubmissionResult(
        Long problemId,
        Boolean isCorrect
) {
}
