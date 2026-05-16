package com.wanted.codebombalms.domain.submission.service;

import com.wanted.codebombalms.domain.submission.dto.response.LatestSubmissionResult;
import com.wanted.codebombalms.domain.submission.repository.SubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SubmissionQueryService {

    private final SubmissionRepository submissionRepository;

    public SubmissionQueryService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Transactional(readOnly = true)
    public Optional<LatestSubmissionResult> findLatestResult(Long userId, Long problemId) {
        return submissionRepository
                .findTopByUserIdAndProblem_ProblemIdOrderBySubmittedAtDesc(userId, problemId)
                .map(submission -> new LatestSubmissionResult(
                        submission.getProblem().getProblemId(),
                        submission.getProblem().getProblemOrder(),
                        submission.getSubmittedAnswer(),
                        submission.getCorrect(),
                        submission.getSubmittedAt()
                ));
    }
}
