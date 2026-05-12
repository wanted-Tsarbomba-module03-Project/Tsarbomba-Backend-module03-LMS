package com.wanted.codebombalms.domain.problems.set.service;

import com.wanted.codebombalms.domain.problems.category.service.ProblemCategoryService;
import com.wanted.codebombalms.domain.problems.problem.dto.response.ProblemResponse;
import com.wanted.codebombalms.domain.problems.problem.service.ProblemService;
import com.wanted.codebombalms.domain.problems.progress.service.ProgressService;
import com.wanted.codebombalms.domain.problems.set.dto.response.SetEnterResponse;
import com.wanted.codebombalms.domain.problems.set.dto.response.SetResponse;
import com.wanted.codebombalms.domain.problems.set.entity.ProblemSet;
import com.wanted.codebombalms.domain.problems.set.exception.SetNotFoundException;
import com.wanted.codebombalms.domain.problems.set.repository.ProblemSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemSetService {

    private final ProblemSetRepository problemSetRepository;
    private final ProblemCategoryService problemCategoryService;
    private final ProblemService problemService;
    private final ProgressService progressService;

    public ProblemSetService(
            ProblemSetRepository problemSetRepository,
            ProblemCategoryService problemCategoryService,
            ProblemService problemService,
            ProgressService progressService
    ) {
        this.problemSetRepository = problemSetRepository;
        this.problemCategoryService = problemCategoryService;
        this.problemService = problemService;
        this.progressService = progressService;
    }

    public List<SetResponse> findActiveSetsByCategory(Long categoryId) {
        if (!problemCategoryService.existsActiveCategory(categoryId)) {
            throw new SetNotFoundException("존재하지 않는 문제 분야입니다.");
        }

        return problemSetRepository
                .findByCategory_CategoryIdAndStatusOrderByProblemSetIdAsc(categoryId, "ACTIVE")
                .stream()
                .map(SetResponse::new)
                .toList();
    }

    public SetEnterResponse enterProblemSet(Long problemSetId, Long userId) {
        ProblemSet problemSet = problemSetRepository.findById(problemSetId)
                .orElseThrow(() -> new SetNotFoundException("존재하지 않는 문제 세트입니다."));

        Integer currentProblemNumber =
                progressService.findCurrentProblemNumber(userId, problemSetId);

        ProblemResponse currentProblem =
                problemService.findCurrentProblem(problemSetId, currentProblemNumber);

        return new SetEnterResponse(
                problemSet.getProblemSetId(),
                problemSet.getTitle(),
                currentProblemNumber,
                currentProblem.getProblemId(),
                currentProblem.getTitle(),
                currentProblem.getContent(),
                currentProblem.getProblemType()
        );
    }
}
