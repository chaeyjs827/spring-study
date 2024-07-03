package com.sfc.study.lock.service;

import com.sfc.study.lock.entity.OptimisticLockAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OptimisticLockServiceTest {

    @Autowired
    private OptimisticLockService optimisticLockService;

    @Test
    void update() {
        optimisticLockService.insert(1000.0, 0L);
        optimisticLockService.insert(2000.0, 0L);

        // 낙관적 락 사용
        Long accountId = 1L;
        OptimisticLockAccount account = optimisticLockService.findById(accountId);
        if (account != null) {
            System.out.println("Before update : " + account.getBalance());
            boolean success = optimisticLockService.update(accountId, -500.0, account.getVersion());
            if (success) {
                System.out.println("After update : " + optimisticLockService.findById(accountId).getBalance());
            } else {
                System.out.println("Update failed due to version mismatch");
            }
        }


    }
}