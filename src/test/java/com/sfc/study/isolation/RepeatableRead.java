package com.sfc.study.isolation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class RepeatableRead {

    private static Map<String, Integer> database = new HashMap<>();

    @Test
    public void test_repeatable_read() {

        // 초기 데이터베이스 상태
        database.put("key1", 100);

        // 트랜잭션 1 : 데이터 읽기
        new Thread(() -> {
            int firstRead = database.get("key1");
            System.out.println("Repeatable Read (first read) : " + firstRead);

            try {
                Thread.sleep(100);  // 다른 트랜잭션이 작업할 시간을 줌
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int secondread = database.get("key1");
            System.out.println("Repeatbale Read (second read) : " + secondread); // 항상 100을 읽음
        }).start();

        // 트랜잭션 2 : 데이터 업데이트(커밋됨)
        new Thread(() -> {
            try {
                Thread.sleep(50); // 트랜잭션 1이 첫 번쨰 읽기를 완료할 시간을 줌
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            database.put("key1", 200);
            // 커밋
        }).start();
    }


}
