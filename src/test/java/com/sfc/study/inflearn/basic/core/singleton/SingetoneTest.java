package com.sfc.study.inflearn.basic.core.singleton;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.sfc.study.inflearn.basic.core.AppConfig;
import com.sfc.study.inflearn.basic.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingetoneTest {


    @Test
    @DisplayName("싱글톤 객체")
    void singleTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = context.getBean("memberService", MemberService.class);
        MemberService memberService2 = context.getBean("memberService", MemberService.class);

        // 두 개의 참조값이 동일한지 확인
        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        // memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);


    }

    
}
