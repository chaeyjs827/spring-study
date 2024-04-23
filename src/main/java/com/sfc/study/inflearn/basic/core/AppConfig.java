package com.sfc.study.inflearn.basic.core;

import com.sfc.study.inflearn.basic.core.discount.DiscountPolicy;
import com.sfc.study.inflearn.basic.core.discount.RateDiscountPolicy;
import com.sfc.study.inflearn.basic.core.member.MemberRepository;
import com.sfc.study.inflearn.basic.core.member.MemberService;
import com.sfc.study.inflearn.basic.core.member.MemberServiceImple;
import com.sfc.study.inflearn.basic.core.member.MemoryMemberRepository;
import com.sfc.study.inflearn.basic.core.order.OrderService;
import com.sfc.study.inflearn.basic.core.order.OrderServiceImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImple(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImple(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

}
