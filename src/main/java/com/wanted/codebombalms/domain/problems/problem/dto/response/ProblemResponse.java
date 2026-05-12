package com.wanted.codebombalms.domain.problems.problem.dto.response;

import com.wanted.codebombalms.domain.problems.problem.entitiy.Problem;

public class ProblemResponse {

    private Long problemId;
    private String title;
    private String content;
    private String problemType;

    public ProblemResponse(Problem problem) {
        this.problemId = problem.getProblemId();
        this.title = problem.getTitle();
        this.content = problem.getContent();
        this.problemType = problem.getProblemType();
    }

    public Long getProblemId() {
        return problemId;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

    public String getProblemType() {
        return problemType;
    }
}