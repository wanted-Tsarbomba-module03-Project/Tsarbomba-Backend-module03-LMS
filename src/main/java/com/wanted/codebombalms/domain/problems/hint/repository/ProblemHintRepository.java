package com.wanted.codebombalms.domain.problems.hint.repository;

import com.wanted.codebombalms.domain.problems.hint.entity.ProblemHint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemHintRepository extends JpaRepository<ProblemHint, Long> {

    List<ProblemHint> findByProblem_ProblemIdOrderByHintOrderAsc(Long problemId);
}
