package com.wanted.codebombalms.domain.problems.set.dto.response;

import com.wanted.codebombalms.domain.problems.set.entity.ProblemSet;

import java.time.LocalDateTime;

public record SetResponse(
        Long problemSetId,
        Integer problemNumber,
        String title,
        String description,
        String difficulty,
        Double accuracyRate,
        LocalDateTime createdAt
) {
    public SetResponse(ProblemSet problemSet, Integer problemNumber) {
        this(
                problemSet.getProblemSetId(),
                problemNumber,
                problemSet.getTitle(),
                problemSet.getDescription(),
                problemSet.getDifficulty(),
                0.0,
                problemSet.getCreatedAt()
        );
    }
}
