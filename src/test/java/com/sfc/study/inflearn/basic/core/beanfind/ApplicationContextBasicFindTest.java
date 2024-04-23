package com.sfc.study.inflearn.basic.core.beanfind;

import com.sfc.study.inflearn.basic.core.AppConfig;
import com.sfc.study.inflearn.basic.core.member.MemberService;
import com.sfc.study.inflearn.basic.core.member.MemberServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {


    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



    @Test
    @DisplayName("이름으로 조회")
    void findBeanByName() {
        MemberService memberService = (MemberService) context.getBean("memberService");
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType() {
        MemberService memberService = context.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName1() {
        MemberService memberService = context.getBean("memberService", MemberServiceImple.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("조회")
    void findBeanByName2() {
        MemberService memberService = context.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("실패 케이스 - 없는 빈 이름으로 조회")
    void failedFindBeanByName() {
        assertThrows(NoSuchBeanDefinitionException.class
                , () -> context.getBean("memberService1"));
    }
}
