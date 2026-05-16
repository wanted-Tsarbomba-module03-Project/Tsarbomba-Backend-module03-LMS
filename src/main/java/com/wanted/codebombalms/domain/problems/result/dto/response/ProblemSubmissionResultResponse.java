package com.wanted.codebombalms.domain.problems.result.dto.response;

import java.time.LocalDateTime;

public record ProblemSubmissionResultResponse(
        Long problemId,
        Integer problemNumber,
        String title,
        String content,
        String submittedAnswer,
        Boolean isCorrect,
        LocalDateTime submittedAt,
        String explanation
) {
}
