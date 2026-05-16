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
import java.util.stream.IntStream;

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

        List<ProblemSet> problemSets = problemSetRepository
                .findByCategory_CategoryIdAndStatusOrderByProblemSetIdAsc(categoryId, "ACTIVE");

        return IntStream.range(0, problemSets.size())
                .mapToObj(index -> new SetResponse(problemSets.get(index), index + 1))
                .toList();
    }

    public SetEnterResponse enterProblemSet(Long problemSetId, Long userId) {
        ProblemSet problemSet = problemSetRepository.findById(problemSetId)
                .orElseThrow(() -> new SetNotFoundException("존재하지 않는 문제 세트입니다."));

        Integer currentProblemNumber =
                progressService.findOrCreateCurrentProblemNumber(userId, problemSet);
        Boolean isCompleted = progressService.isCompleted(userId, problemSet);

        ProblemResponse currentProblem = isCompleted
                ? problemService.findLastProblem(problemSetId).orElse(null)
                : problemService.findCurrentProblem(problemSetId, currentProblemNumber);

        return new SetEnterResponse(
                problemSet.getProblemSetId(),
                problemSet.getTitle(),
                problemSet.getDescription(),
                currentProblemNumber,
                isCompleted,
                currentProblem
        );
    }
}
