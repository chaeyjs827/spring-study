package com.sfc.study.inflearn.basic.core;

import com.sfc.study.inflearn.basic.core.member.Grade;
import com.sfc.study.inflearn.basic.core.member.Member;
import com.sfc.study.inflearn.basic.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);

        System.out.println("test");
    }

}
