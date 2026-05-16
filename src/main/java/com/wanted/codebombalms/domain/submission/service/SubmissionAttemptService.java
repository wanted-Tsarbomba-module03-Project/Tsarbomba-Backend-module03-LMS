package com.wanted.codebombalms.domain.submission.service;

import com.wanted.codebombalms.domain.problems.problem.entitiy.Problem;
import org.springframework.stereotype.Service;

@Service
public class SubmissionAttemptService {

    public void validateAttemptLimit(Problem problem, int previousAttemptCount) {
        if (problem.getAttemptLimit() != null && previousAttemptCount >= problem.getAttemptLimit()) {
            throw new RuntimeException("제출 가능 횟수를 초과했습니다.");
        }

        if (!Boolean.TRUE.equals(problem.getRetriable()) && previousAttemptCount > 0) {
            throw new RuntimeException("재시도할 수 없는 문제입니다.");
        }
    }

    public int calculateRemainingAttemptCount(Integer attemptLimit, int attemptNo) {
        if (attemptLimit == null) {
            return 0;
        }

        return Math.max(attemptLimit - attemptNo, 0);
    }

    public boolean canRetry(Boolean isRetriable, int remainingAttemptCount, boolean isCorrect) {
        return !isCorrect
                && Boolean.TRUE.equals(isRetriable)
                && remainingAttemptCount > 0;
    }
}
