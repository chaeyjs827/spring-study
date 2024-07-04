package com.sfc.study.flowcontrol;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestBySemaphoreAndExecutor {

    private static final int MAX_CONCURRENT_REQUEST = 5;
    private static final int REQUEST_INTERVAL_MS = 100;
    private static final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_REQUEST);

    @Test
    public void test_by_semaphore_executor_service() {
        // 최대 동시 요청 수를 기반으로 스레드 풀을 생성합니다.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(MAX_CONCURRENT_REQUEST);

        int testSize = 10000;

        for (int i = 0; i < 100000; i++) {
            final int requestId = i;
            scheduler.schedule(() -> {
                try {
                    // 요청을 실행하기 전에 Semaphore를 통해 동시 요청 수를 제어합니다.
                    semaphore.acquire();
                    makeRequest(requestId);
                } catch (InterruptedException e) {
                    // 인터럽트가 발생하면 스레드의 인터럽트 상태를 복원합니다.
                    Thread.currentThread().interrupt();
                } finally {
                    // 요청이 완료되면 Semaphore의 허가를 해제합니다.
                    semaphore.release();
                }
            }, requestId * REQUEST_INTERVAL_MS, TimeUnit.MILLISECONDS);
        }

        // 스케줄러를 종료하고 모든 작업이 완료될 때까지 대기합니다.
        scheduler.shutdown();
        try {
            scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // 인터럽트가 발생하면 스레드의 인터럽트 상태를 복원합니다.
            Thread.currentThread().interrupt();
        }
    }

    private void makeRequest(int requestId) {
        System.out.println(requestId + " 가 요청되었습니다.");
    }

}
