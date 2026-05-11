package com.wanted.codebombalms.domain.problem.set.dto.response;

public class SetEnterResponse {

    private Long problemSetId;
    private String problemSetTitle;
    private Integer currentProblemNumber;
    private Long problemId;
    private String problemTitle;
    private String problemContent;
    private String problemType;

    public SetEnterResponse(
            Long problemSetId,
            String problemSetTitle,
            Integer currentProblemNumber,
            Long problemId,
            String problemTitle,
            String problemContent,
            String problemType
    ) {
        this.problemSetId = problemSetId;
        this.problemSetTitle = problemSetTitle;
        this.currentProblemNumber = currentProblemNumber;
        this.problemId = problemId;
        this.problemTitle = problemTitle;
        this.problemContent = problemContent;
        this.problemType = problemType;
    }

    public Long getProblemSetId() {
        return problemSetId;
    }

    public String getProblemSetTitle() {
        return problemSetTitle;
    }

    public Integer getCurrentProblemNumber() {
        return currentProblemNumber;
    }

    public Long getProblemId() {
        return problemId;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public String getProblemType() {
        return problemType;
    }
}
