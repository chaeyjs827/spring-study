package com.sfc.study.jpa.ex2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstCacheTargetServiceTest {

    @Autowired
    private FirstCacheTargetService firstCacheTargetService;

    @Test
    void firstCacheTestByPersist() {
        firstCacheTargetService.firstCacheTestByPersist();
    }

    @Test
    void firstCacheTestByWithoutPersist() {
        firstCacheTargetService.firstCacheTestByWithoutPersist();
    }

    @Test
    void firstCacheTestByFind() {
        firstCacheTargetService.firstCacheTestByFind();
    }

    @Test
    void firstCacheTestBySelectOfJPQL() {
        firstCacheTargetService.firstCacheTestBySelectOfJPQL();
    }

    @Test
    void firstCacheTestByMerge() {
        firstCacheTargetService.firstCacheTestByMerge();
    }

    @Test
    void firstCacheTestByFlush() {
        firstCacheTargetService.firstCacheTestByFlush();
    }
}