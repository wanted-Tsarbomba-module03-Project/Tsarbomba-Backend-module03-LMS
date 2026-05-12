package com.wanted.codebombalms.domain.problem.set.dto.response;

import com.wanted.codebombalms.domain.problem.set.entity.ProblemSet;

public class SetResponse {

    private Long problemSetId;
    private String title;

    public SetResponse(ProblemSet problemSet) {
        this.problemSetId = problemSet.getProblemSetId();
        this.title = problemSet.getTitle();
    }

    public Long getProblemSetId() {
        return problemSetId;
    }

    public String getTitle() {
        return title;
    }
}
