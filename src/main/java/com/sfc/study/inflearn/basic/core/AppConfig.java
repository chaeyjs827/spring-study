package com.sfc.study.inflearn.basic.core;

import com.sfc.study.inflearn.basic.core.discount.FixDiscountPolicy;
import com.sfc.study.inflearn.basic.core.member.MemberService;
import com.sfc.study.inflearn.basic.core.member.MemberServiceImple;
import com.sfc.study.inflearn.basic.core.member.MemoryMemberRepository;
import com.sfc.study.inflearn.basic.core.order.OrderService;
import com.sfc.study.inflearn.basic.core.order.OrderServiceImple;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImple(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImple(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
