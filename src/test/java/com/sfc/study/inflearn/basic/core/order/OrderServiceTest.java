package com.sfc.study.inflearn.basic.core.order;

import com.sfc.study.inflearn.basic.core.discount.DiscountPolicy;
import com.sfc.study.inflearn.basic.core.discount.FixDiscountPolicy;
import com.sfc.study.inflearn.basic.core.member.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberRepository memberRepository = new MemoryMemberRepository();

    MemberService memberService = new MemberServiceImple(memberRepository);

    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    OrderService orderService = new OrderServiceImple();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order.toString());
        System.out.println(order.calculatePrice());
    }
}