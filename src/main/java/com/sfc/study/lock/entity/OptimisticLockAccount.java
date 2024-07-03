package com.sfc.study.lock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptimisticLockAccount {

    private Long id;
    private Double balance;
    private Long version;

    public OptimisticLockAccount(Long id, Double balance, Long version) {
        this.id = id;
        this.balance = balance;
        this.version = version;
    }
}
