package com.wanted.codebombalms.domain.problems.submission.repository;

import com.wanted.codebombalms.domain.problems.submission.entitiy.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    int countByUserIdAndProblem_ProblemId(Long userId, Long problemId);
}