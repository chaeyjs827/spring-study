package com.sfc.study.inflearn.basic.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingletonTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = context.getBean(StatefulService.class);
        StatefulService statefulService2 = context.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        statefulService1.order("userA", 10000);

        // ThreadA : B사용자 10000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA : 사용자A 주문 금액 조회
        int priceA = statefulService1.getPrice();
        System.out.println("priceA : " + priceA);

        // ThreadB : 사용자B 주문 금액 조회
        int priceB = statefulService2.getPrice();
        System.out.println("priceB : " + priceB);

        Assertions.assertThat(priceA).isNotEqualTo(10000); // 당연히 실패합니다. 싱글톤 인스턴스의 price는 priceB로 갱신 되었기 때문에!
        Assertions.assertThat(priceB).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}