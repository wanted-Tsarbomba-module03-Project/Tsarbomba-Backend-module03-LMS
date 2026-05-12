package com.wanted.codebombalms.domain.problem.problem.service;

import com.wanted.codebombalms.domain.problem.problem.dto.response.ProblemResponse;
import com.wanted.codebombalms.domain.problem.problem.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProblemService {
    private final ProblemRepository problemRepository;


    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<ProblemResponse> findProblemsByCategory(Long categoryId) {
        return problemRepository
                .findByProblemSet_Category_CategoryIdAndStatusOrderByProblemOrderAsc(categoryId, "ACTIVE")
                .stream()
                .map(ProblemResponse::new)
                .toList();
    }
    public ProblemResponse findCurrentProblem(Long problemSetId,
                                              Integer currentProblemNumber) {
        return problemRepository
                .findByProblemSet_ProblemSetIdAndProblemOrderAndStatus(
                        problemSetId,
                        currentProblemNumber,
                        "ACTIVE"
                )
                .map(ProblemResponse::new)
                .orElseThrow(() -> new RuntimeException("현재 풀 문제가 없습니다."));

    }
}
