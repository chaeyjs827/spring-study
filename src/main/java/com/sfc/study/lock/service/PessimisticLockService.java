package com.sfc.study.lock.service;

import com.sfc.study.lock.entity.PessimisticLockAccount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PessimisticLockService {

    private static Map<Long, PessimisticLockAccount> store = new HashMap<>();
    private static long sequence = 0L;

    public static synchronized PessimisticLockAccount findById(Long id) {
        return store.get(id);
    }

    public static void insert(PessimisticLockAccount pessimisticLockAccount) {
        store.put(++sequence, pessimisticLockAccount);
    }

    public static synchronized void update(Long id, Double amount) {
        PessimisticLockAccount account = store.get(id);
        if (account == null) {
            account.setBalance(account.getBalance() + amount);
        }
    }

}
