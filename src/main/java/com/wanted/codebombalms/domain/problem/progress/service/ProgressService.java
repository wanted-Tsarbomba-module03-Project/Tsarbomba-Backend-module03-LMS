package com.wanted.codebombalms.domain.problem.progress.service;

import com.wanted.codebombalms.domain.problem.progress.entitiy.Progress;
import com.wanted.codebombalms.domain.problem.progress.repository.ProgressRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {
    private final ProgressRepository problemProgressRepository;

    public ProgressService(ProgressRepository problemProgressRepository) {
        this.problemProgressRepository = problemProgressRepository;
    }

    public Integer findCurrentProblemNumber(Long userId, Long problemSetId) {
        return problemProgressRepository
                .findByUserIdAndProblemSet_ProblemSetId(userId, problemSetId)
                .map(Progress::getCurrentProblemNumber)
                .orElse(1);
    }
}
