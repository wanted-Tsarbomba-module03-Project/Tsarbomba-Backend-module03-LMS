package com.wanted.codebombalms.domain.problems.set.repository;

import com.wanted.codebombalms.domain.problems.set.entity.ProblemSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemSetRepository extends JpaRepository<ProblemSet, Long> {

    List<ProblemSet> findByCategory_CategoryIdAndStatusOrderByProblemSetIdAsc(
            Long categoryId,
            String status
    );
}
