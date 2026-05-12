package com.wanted.codebombalms.domain.problems.set.dto.response;

import com.wanted.codebombalms.domain.problems.set.entity.ProblemSet;

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
