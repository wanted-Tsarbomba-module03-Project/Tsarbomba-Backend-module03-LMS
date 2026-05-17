package com.wanted.codebombalms.domain.submission.event;

public record ProblemSetCompletedEvent(
        Long userId,
        Long problemSetId
) {
}
