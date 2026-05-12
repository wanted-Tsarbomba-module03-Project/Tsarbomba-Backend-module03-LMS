package com.wanted.codebombalms.domain.problems.progress.service;

import com.wanted.codebombalms.domain.problems.progress.entitiy.Progress;
import com.wanted.codebombalms.domain.problems.progress.repository.ProgressRepository;
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

    public Integer openNextProblem(Long userId, Long problemSetId, Long solvedProblemId) {
        Progress progress = problemProgressRepository
                .findByUserIdAndProblemSet_ProblemSetId(userId, problemSetId)
                .orElseThrow(() -> new RuntimeException("진행 상태가 없습니다."));

        progress.openNextProblem(solvedProblemId);
        Progress savedProgress = problemProgressRepository.save(progress);

        return savedProgress.getCurrentProblemNumber();
    }

    public void completeProblemSet(Long userId, Long problemSetId) {
        Progress progress = problemProgressRepository
                .findByUserIdAndProblemSet_ProblemSetId(userId, problemSetId)
                .orElseThrow(() -> new RuntimeException("진행 상태가 없습니다."));

        progress.complete();
        problemProgressRepository.save(progress);
    }
}
