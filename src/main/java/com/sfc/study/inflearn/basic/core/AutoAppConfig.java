package com.sfc.study.inflearn.basic.core;

import com.sfc.study.inflearn.basic.core.member.MemberService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.sfc.study.inflearn.basic.core"
        , basePackageClasses = AutoAppConfig.class
        , excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    private MemberService memberService;

}
