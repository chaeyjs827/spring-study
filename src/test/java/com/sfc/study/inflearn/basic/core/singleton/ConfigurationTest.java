package com.sfc.study.inflearn.basic.core.singleton;

import com.sfc.study.inflearn.basic.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {

    @Test
    void configurationDeep() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = context.getBean(AppConfig.class);

        System.out.println("[test console] bean = " + bean.getClass());

    }

}
