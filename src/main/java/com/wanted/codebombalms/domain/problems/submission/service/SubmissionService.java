package com.wanted.codebombalms.domain.problems.submission.service;

import com.wanted.codebombalms.domain.problems.problem.entitiy.Problem;
import com.wanted.codebombalms.domain.problems.problem.service.ProblemService;
import com.wanted.codebombalms.domain.problems.progress.service.ProgressService;
import com.wanted.codebombalms.domain.problems.submission.dto.request.SubmissionRequest;
import com.wanted.codebombalms.domain.problems.submission.dto.response.SubmissionResponse;
import com.wanted.codebombalms.domain.problems.submission.entitiy.Submission;
import com.wanted.codebombalms.domain.problems.submission.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final ProblemService problemService;
    private final ProgressService progressService;

    public SubmissionService(SubmissionRepository submissionRepository, ProblemService problemService, ProgressService progressService) {
        this.submissionRepository = submissionRepository;
        this.problemService = problemService;
        this.progressService = progressService;
    }

    private boolean gradeTextAnswer(String correctAnswer, String submittedAnswer) {
        return correctAnswer.equals(submittedAnswer);
    }

    public SubmissionResponse submitAnswer(Long problemId, SubmissionRequest request) {
        if (request.getSubmittedAnswer() == null || request.getSubmittedAnswer().isEmpty()) {
            throw new IllegalArgumentException("답안을 입력해주세요.");
        }

        Problem problem = problemService.findProblemEntity(problemId);

        boolean isCorrect = gradeTextAnswer(problem.getAnswer(), request.getSubmittedAnswer());

        int earnedScore = isCorrect ? problem.getScore() : 0;

        int attemptNo = submissionRepository
                .countByUserIdAndProblem_ProblemId(request.getUserId(), problemId) + 1;
        int remainingAttemptCount = calculateRemainingAttemptCount(problem.getAttemptLimit(), attemptNo);
        boolean canRetry = canRetry(problem.getRetriable(), remainingAttemptCount, isCorrect);

        Submission submission = new Submission(
                request.getUserId(),
                problem,
                request.getSubmittedAnswer(),
                isCorrect,
                earnedScore,
                attemptNo
        );

        submissionRepository.save(submission);

        Long nextProblemId = null;
        boolean isProblemSetCompleted = false;

        if (isCorrect) {
            Integer nextProblemNumber = progressService.openNextProblem(
                    request.getUserId(),
                    problem.getProblemSet().getProblemSetId(),
                    problem.getProblemId()
            );

            nextProblemId = problemService
                    .findProblemIdByProblemSetAndOrder(problem.getProblemSet().getProblemSetId(), nextProblemNumber)
                    .orElse(null);

            if (nextProblemId == null) {
                isProblemSetCompleted = true;
                progressService.completeProblemSet(
                        request.getUserId(),
                        problem.getProblemSet().getProblemSetId()
                );
            }
        }

        return new SubmissionResponse(
                problem.getProblemId(),
                isCorrect,
                attemptNo,
                remainingAttemptCount,
                canRetry,
                nextProblemId,
                isProblemSetCompleted
        );
    }

    private int calculateRemainingAttemptCount(Integer attemptLimit, int attemptNo) {
        if (attemptLimit == null) {
            return 0;
        }

        return Math.max(attemptLimit - attemptNo, 0);
    }

    private boolean canRetry(Boolean isRetriable, int remainingAttemptCount, boolean isCorrect) {
        return !isCorrect
                && Boolean.TRUE.equals(isRetriable)
                && remainingAttemptCount > 0;
    }

}
