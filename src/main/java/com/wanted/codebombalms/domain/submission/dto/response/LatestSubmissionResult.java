package com.wanted.codebombalms.domain.submission.dto.response;

import java.time.LocalDateTime;

public record LatestSubmissionResult(
        Long problemId,
        Integer problemNumber,
        String submittedAnswer,
        Boolean isCorrect,
        LocalDateTime submittedAt
) {
}
