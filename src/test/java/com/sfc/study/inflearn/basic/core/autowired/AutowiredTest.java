package com.sfc.study.inflearn.basic.core.autowired;

import com.sfc.study.inflearn.basic.core.member.Member;
import com.sfc.study.inflearn.basic.core.scan.AutowiredTestBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(AutowiredTestBean noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBeam2(@Nullable AutowiredTestBean noBeam2) {
            System.out.println("noBeam2 = " + noBeam2);
        }

        @Autowired
        public void setBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }

    }




}
