package com.sfc.study.isolation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
public class SerializableTest {

    private static Map<String, Integer> database = new HashMap<>();
    private static ReentrantLock lock = new ReentrantLock();

    @Test
    public void test_serializable() {
        // 초기 데이터베이스 상태
        database.put("key1", 100);

        // 트랜잭션 1 : 데이터 읽기 및 업데이트
        new Thread(() -> {
            lock.lock(); // 트랜잭션 시작

            try {
                int value = database.get("key1");
                System.out.println("Serializable (read) : " + value);
                value += 50;
                database.put("key1", value);
                // 커밋
            } finally {
                lock.unlock(); // 트랜잭션 종료
            }
        }).start();

        // 트랜잭션 2 : 데이터 읽기
        new Thread(() -> {
            lock.lock();
            try {
                int value = database.get("key1");
                System.out.println("Serializable (read) : " + value);
                // 직렬화 보장으로 인해 트랜잭션 1 종료 후에만 실행됨
            } finally {
                lock.unlock();  // 트랜잭션 종료
            }
        }).start();

    }

}
