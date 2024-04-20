package com.sfc.study.inflearn.entrance.ex3.controller;

import com.sfc.study.inflearn.entrance.ex3.service.BeanMemberService;
import com.sfc.study.inflearn.entrance.ex3.service.BeanServiceAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BeanMemberController {

    // 의존성 주입(Dependency Injection 방법) - 첫번째 @Autowired 사용
    @Autowired
    private BeanServiceAnnotationService beanServiceAnnotationService;


    // 의존성 주입(Dependency Injection 방법) - 두 번째 생성자 사용
    // 생성자 방식을 사용하는게 가장 좋다고 한다.
    private final BeanMemberService beanMemberService;

    public BeanMemberController(
            BeanMemberService beanMemberService
    ) {
        this.beanMemberService = beanMemberService;
    }



}
