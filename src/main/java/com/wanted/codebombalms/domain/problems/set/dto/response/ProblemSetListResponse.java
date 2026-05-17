package com.wanted.codebombalms.domain.problems.set.dto.response;

import com.wanted.codebombalms.domain.problems.set.entity.ProblemSet;

import java.time.LocalDateTime;

public record ProblemSetListResponse(
        Long problemSetId,
        Integer problemNumber,
        String title,
        String description,
        String difficulty,
        Double accuracyRate,
        LocalDateTime createdAt
) {
    public ProblemSetListResponse(ProblemSet problemSet, Integer problemNumber) {
        this(
                problemSet.getProblemSetId(),
                problemNumber,
                problemSet.getTitle(),
                problemSet.getDescription(),
                problemSet.getDifficulty(),
                calculateAccuracyRate(problemSet),
                problemSet.getCreatedAt()
        );
    }

    private static Double calculateAccuracyRate(ProblemSet problemSet) {
        int completedUserCount = toZeroIfNull(problemSet.getCompletedUserCount());
        int startedUserCount = toZeroIfNull(problemSet.getStartedUserCount());

        if (startedUserCount == 0) {
            return 0.0;
        }

        double rate = completedUserCount * 100.0 / startedUserCount;
        return Math.round(rate * 10) / 10.0;
    }

    private static int toZeroIfNull(Integer value) {
        if (value == null) {
            return 0;
        }

        return value;
    }
}
