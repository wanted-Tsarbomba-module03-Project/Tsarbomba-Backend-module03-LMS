package com.wanted.codebombalms.domain.submission.service;

import org.springframework.stereotype.Service;

@Service
public class AnswerGradingService {

    public boolean gradeTextAnswer(String correctAnswer, String submittedAnswer) {
        return correctAnswer != null && correctAnswer.equals(submittedAnswer);
    }
}
