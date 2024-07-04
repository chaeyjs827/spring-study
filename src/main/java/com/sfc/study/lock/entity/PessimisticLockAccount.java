package com.sfc.study.lock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessimisticLockAccount {

    private Long id;
    private Double balance;

    public PessimisticLockAccount() {
    }

    public PessimisticLockAccount(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }
}
