package com.sfc.study.inflearn.entrance.ex3.config;

import com.sfc.study.inflearn.entrance.ex3.controller.BeanMemberController;
import com.sfc.study.inflearn.entrance.ex3.repository.BeanMemberRepository;
import com.sfc.study.inflearn.entrance.ex3.repository.BeanMemoryMemberRepository;
import com.sfc.study.inflearn.entrance.ex3.service.BeanMemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 직접 자바 코드로 Bean 생성하는 방법
 */
@Configuration
public class BeanSpringConfig {

    @Bean
    public BeanMemberService beanMemberService() {
        return new BeanMemberService(beanMemberRepository());
    }

    @Bean
    public BeanMemberRepository beanMemberRepository() {
        return new BeanMemoryMemberRepository();
    }

}
