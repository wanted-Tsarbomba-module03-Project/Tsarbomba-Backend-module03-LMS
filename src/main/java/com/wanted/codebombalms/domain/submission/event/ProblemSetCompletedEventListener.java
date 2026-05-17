package com.wanted.codebombalms.domain.submission.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class ProblemSetCompletedEventListener {

    private static final Logger log = LoggerFactory.getLogger(ProblemSetCompletedEventListener.class);

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(ProblemSetCompletedEvent event) {
        log.info("[ProblemSetCompletedEventListener] 문제 세트 완료 이벤트 처리 - userId: {}, problemSetId: {}",
                event.userId(),
                event.problemSetId()
        );
    }
}

