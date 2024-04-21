package com.sfc.study.inflearn.entrance.ex4.controller;

import com.sfc.study.inflearn.entrance.ex4.domain.Ex4Member;
import com.sfc.study.inflearn.entrance.ex4.service.Ex4MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrance/member")
public class Ex4MemberController {

    private final Ex4MemberService ex4MemberService;

    public Ex4MemberController(
            Ex4MemberService ex4MemberService
    ) {
        this.ex4MemberService = ex4MemberService;
    }

    @PostMapping("/{id}/{name}")
    public void join(@PathVariable Long id, @PathVariable String name) {
        Ex4Member member = new Ex4Member();
        member.setId(1L);
        member.setName("test");
        ex4MemberService.save(member);
    }

    @GetMapping("/{memberId}")
    @ResponseBody
    public Ex4Member getMember(@PathVariable Long memberId) {
        return ex4MemberService.getMember(memberId);
    }

}
