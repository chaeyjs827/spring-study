package com.sfc.study.isolation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ReadCommited {

    private static Map<String, Integer> database = new HashMap<>();

    @Test
    public void test_read_commited() {
        //초기 데이터베이스 상태
        database.put("key1", 100);

        // 트랜잭션 1 : 데이터 업데이트(커밋됨)
        new Thread(() -> {
            database.put("key1", 200);
        }).start();

        // 트랜잭션 2 : 데이터 읽기
        new Thread(() -> {
            try {
                Thread.sleep(100);  // 트랜잭션 1이 업데이트하고 커밋할 시간을 줌
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Read Committed (first read): " + database.get("key1")); // 200을 읽음

            try {
                Thread.sleep(100); // 일부러 지연
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Read Committed (second read): " + database.get("key1"));
            // 동일한 트랜잭션 내에서 다른 값을 읽음 (Non-repeatable Read)

            /**
             * Commited-read 이기 때문에 Dirty Read는 발새하지 않습니다.
             * 하지만 non-repeatable read 문제가 발생합니다.
             * -> 일종의 동시성 문제입니다. 한 트랜잭션이 두 번 이상 같은 데이터를 읽는 동안,
             * 다른 트랜잭션이 그 데이터를 수정하거나 삭제하여 두 번의 읽기 결과가 다를 때 발생합니다.
             *
             * ex)
             * 1. 트랜잭션 A가 계좌 잔액을 조회합니다.
             * 2. 트랜잭션 B가 동일한 계좌의 잔액을 수정합니다.
             * 3. 트랜잭션 A가 다시 동일한 계좌의 잔액을 조회합니다. (잔액이 다르게 표시)
             *
             *
             */


        });
    }

}
