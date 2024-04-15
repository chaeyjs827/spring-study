package com.sfc.study.inflearn.entrance.ex2.controller;

import com.sfc.study.inflearn.entrance.ex2.service.Ex2MemberService;
import org.springframework.stereotype.Controller;

/**
 * Component-scan => @Component 를 사용해서 Bean 등록하는 방법
 */

@Controller
public class Ex2MemberController {

    private final Ex2MemberService ex2MemberService;

    public Ex2MemberController(
            Ex2MemberService ex2MemberService
    ) {
        this.ex2MemberService = ex2MemberService;
    }

}
