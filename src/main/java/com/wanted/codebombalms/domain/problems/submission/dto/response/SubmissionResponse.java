package com.wanted.codebombalms.domain.problems.submission.dto.response;

public class SubmissionResponse {

    private Long problemId;
    private Boolean isCorrect;
    private Integer attemptNo;
    private Integer remainingAttemptCount;
    private Boolean canRetry;
    private Long nextProblemId;
    private Boolean isProblemSetCompleted;

    public SubmissionResponse(
            Long problemId,
            Boolean isCorrect,
            Integer attemptNo,
            Integer remainingAttemptCount,
            Boolean canRetry,
            Long nextProblemId,
            Boolean isProblemSetCompleted
    ) {
        this.problemId = problemId;
        this.isCorrect = isCorrect;
        this.attemptNo = attemptNo;
        this.remainingAttemptCount = remainingAttemptCount;
        this.canRetry = canRetry;
        this.nextProblemId = nextProblemId;
        this.isProblemSetCompleted = isProblemSetCompleted;
    }

    public Long getProblemId() {
        return problemId;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public Integer getAttemptNo() {
        return attemptNo;
    }

    public Integer getRemainingAttemptCount() {
        return remainingAttemptCount;
    }

    public Boolean getCanRetry() {
        return canRetry;
    }

    public Long getNextProblemId() {
        return nextProblemId;
    }

    public Boolean getIsProblemSetCompleted() {
        return isProblemSetCompleted;
    }
}
