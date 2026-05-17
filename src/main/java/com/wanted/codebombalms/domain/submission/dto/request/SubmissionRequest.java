package com.wanted.codebombalms.domain.submission.dto.request;

public class SubmissionRequest {

    private Long userId;
    private String submittedAnswer;

    public Long getUserId() {
        return userId;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }
}
