package com.sfc.study.isolation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ReadUncommittedTest {

    private static Map<String, Integer> database = new HashMap<>();

    @Test
    public void test_read_uncommited() {
        // 초기 데이터 베이스 상태
        database.put("key1", 100);

        // 트랜잭션 1 : 데이터 업데이트 (커밋되지 않음)
        new Thread(() -> {
            database.put("key1", 200);
            // 커밋되지 않은 상태
        }).start();

        // 트랜잭션 2 : 데이터 읽기
        new Thread(() -> {
           try {
                Thread.sleep(50); // 트랜잭션 1이 업데이트할 시간을 줌
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
            System.out.println("Read Uncommited : " + database.get("key1"));    // 200을 읽을 수 있음
        }).start();

        // 즉, 트랜잭션1의 값 변경이 아직 커밋되지 않았지만, 트랜잭션2에서는 트랜잭션1의 값을 참조할 수 있습니다.
        // 이는 Dirty Read 문제를 초래할 수 있습니다.


    }




}
