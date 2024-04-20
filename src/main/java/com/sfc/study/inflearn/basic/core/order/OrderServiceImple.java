package com.sfc.study.inflearn.basic.core.order;

import com.sfc.study.inflearn.basic.core.discount.DiscountPolicy;
import com.sfc.study.inflearn.basic.core.member.Member;
import com.sfc.study.inflearn.basic.core.member.MemberRepository;

public class OrderServiceImple implements OrderService {

    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

    public  OrderServiceImple(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
