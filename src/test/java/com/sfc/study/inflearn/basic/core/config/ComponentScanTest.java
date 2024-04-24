package com.sfc.study.inflearn.basic.core.config;

import com.sfc.study.inflearn.basic.core.AutoAppConfig;
import com.sfc.study.inflearn.basic.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void componentScanTest() {
        MemberService memberService = context.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
