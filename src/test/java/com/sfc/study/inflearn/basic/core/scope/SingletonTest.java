package com.sfc.study.inflearn.basic.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean1);
        System.out.println(singletonBean2);

        // 동일한 인스턴스가 반환됨

        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);

    }

    @Scope("singleton") // default 라 굳이 선언 안해도 됨.
    static class SingletonBean {

        @PostConstruct
        public void init() {
            System.out.println("singleton bean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singleton bean destory");
        }

    }


}
