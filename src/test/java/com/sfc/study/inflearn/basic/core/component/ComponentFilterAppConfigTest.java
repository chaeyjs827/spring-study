package com.sfc.study.inflearn.basic.core.component;

import com.sfc.study.inflearn.basic.core.scan.BeanA;
import com.sfc.study.inflearn.basic.core.scan.BeanB;
import com.sfc.study.inflearn.basic.core.scan.filter.MyExcludeComponent;
import com.sfc.study.inflearn.basic.core.scan.filter.MyIncludeComponent;
import org.assertj.core.api.Assertions;
import org.hibernate.annotations.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = context.getBean("beanA", BeanA.class);

        Assertions.assertThat(beanA).isNotNull();
        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> context.getBean("beanB", BeanB.class)
        );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }

}
