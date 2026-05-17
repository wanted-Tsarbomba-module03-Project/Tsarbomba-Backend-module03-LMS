package com.wanted.codebombalms.domain.submission.dto.response;

public record SubmissionResponse(
        Long problemId,
        Boolean isCorrect,
        Integer attemptNo,
        Integer remainingAttemptCount,
        Boolean canRetry,
        Long nextProblemId,
        Boolean isProblemSetCompleted,
        String explanation
) {
}
