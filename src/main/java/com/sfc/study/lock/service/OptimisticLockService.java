package com.sfc.study.lock.service;

import com.sfc.study.lock.entity.OptimisticLockAccount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OptimisticLockService {

    private static Map<Long, OptimisticLockAccount> store = new HashMap<>();
    private static long sequence = 0L;

    public static OptimisticLockAccount findById(long id) {
        return store.get(id);
    }

    public static void insert(Double amount, Long version) {
        store.put(++sequence, new OptimisticLockAccount(sequence, amount, version));
    }

    public static boolean update(Long id, Double amount, Long version) {
        OptimisticLockAccount account = store.get(id);
        if (account != null && account.getVersion().equals(version)) {
            account.setBalance(account.getBalance() + amount);
            account.setVersion(account.getVersion() + 1);
            return true;
        }
        return false;
    }

}
