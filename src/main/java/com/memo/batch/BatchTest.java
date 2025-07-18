package com.memo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BatchTest {

    // 1분마다 실행
    @Scheduled(cron = "0 */1 * * * *")
    public void batchTest() {
        log.info("############ 배치 테스트");
    }
}
