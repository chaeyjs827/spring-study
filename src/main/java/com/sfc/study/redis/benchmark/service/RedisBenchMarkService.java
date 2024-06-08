package com.sfc.study.redis.benchmark.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisBenchMarkService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisBenchMarkService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void benchMark(int numOfOperations) {
        long startTime = System.currentTimeMillis();

        // 데이터 삽입
        for (int i = 0; i < numOfOperations; i++) {
            redisTemplate.opsForValue().set("key:" + i, "value:" + i);
        }

        // 데이터 조회
        for (int i = 0; i < numOfOperations; i++) {
            redisTemplate.opsForValue().get("key:" + i);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Total time for " + numOfOperations + " operations: " + duration + " ms");

    }
}
