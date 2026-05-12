package com.wanted.codebombalms.domain.problem.problem.repository;

import com.wanted.codebombalms.domain.problem.problem.entitiy.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findByProblemSet_Category_CategoryIdAndStatusOrderByProblemOrderAsc(
            Long categoryId,
            String status
    );
    Optional<Problem> findByProblemSet_ProblemSetIdAndProblemOrderAndStatus(
            Long problemSetId,
            Integer problemOrder,
            String status
    );

}
