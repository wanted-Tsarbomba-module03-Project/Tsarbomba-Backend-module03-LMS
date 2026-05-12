package com.wanted.codebombalms.domain.problem.progress.repository;

import com.wanted.codebombalms.domain.problem.progress.entitiy.Progress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserIdAndProblemSet_ProblemSetId(
            Long userId,
            Long problemSetId
    );
}
