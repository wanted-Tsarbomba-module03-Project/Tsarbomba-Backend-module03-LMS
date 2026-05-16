package com.wanted.codebombalms.domain.problems.hint.dto.response;

import com.wanted.codebombalms.domain.problems.hint.entity.ProblemHint;

public record ProblemHintResponse(
        Long hintId,
        Integer hintOrder,
        String hintContent
) {
    public ProblemHintResponse(ProblemHint hint) {
        this(
                hint.getHintId(),
                hint.getHintOrder(),
                hint.getHintContent()
        );
    }
}
