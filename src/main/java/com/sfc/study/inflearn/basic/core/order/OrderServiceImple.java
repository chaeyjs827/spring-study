package com.sfc.study.inflearn.basic.core.order;

import com.sfc.study.inflearn.basic.core.discount.DiscountPolicy;
import com.sfc.study.inflearn.basic.core.discount.FixDiscountPolicy;
import com.sfc.study.inflearn.basic.core.member.Member;
import com.sfc.study.inflearn.basic.core.member.MemberRepository;
import com.sfc.study.inflearn.basic.core.member.MemoryMemberRepository;

public class OrderServiceImple implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
