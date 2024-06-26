package com.sfc.study.inflearn.basic.core.discount;

import com.sfc.study.inflearn.basic.core.member.Grade;
import com.sfc.study.inflearn.basic.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
