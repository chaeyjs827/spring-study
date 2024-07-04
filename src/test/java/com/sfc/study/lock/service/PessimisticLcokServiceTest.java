package com.sfc.study.lock.service;

import com.sfc.study.lock.entity.PessimisticLockAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PessimisticLcokServiceTest {

    @Autowired
    private PessimisticLockService pessimisticLockService;

    @Test
    void update() {
        PessimisticLockAccount pessimisticLockAccount = new PessimisticLockAccount();
        pessimisticLockAccount.setBalance(1000.0);
        pessimisticLockService.insert(pessimisticLockAccount);

        PessimisticLockAccount pessimisticLockAccount2 = new PessimisticLockAccount();
        pessimisticLockAccount2.setBalance(2000.0);
        pessimisticLockService.insert(pessimisticLockAccount2);

        Long accountId = 1L;

        synchronized (OptimisticLockServiceTest.class) {
            PessimisticLockAccount account = pessimisticLockService.findById(accountId);
            if (account != null) {
                System.out.println("Before update : " + account.getBalance());
                pessimisticLockService.update(accountId, -500.0);
                System.out.println("After update : " + account.getBalance());
            }
        }
    }

}
