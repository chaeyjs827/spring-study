package com.sfc.study.inflearn.entrance.ex4.controller;

import com.sfc.study.inflearn.entrance.ex4.domain.Member;
import com.sfc.study.inflearn.entrance.ex4.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrance/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(
            MemberService memberService
    ) {
        this.memberService = memberService;
    }

    @PostMapping("/{id}/{name}")
    public void join(@PathVariable Long id, @PathVariable String name) {
        Member member = new Member();
        member.setId(1L);
        member.setName("test");
        memberService.save(member);
    }

    @GetMapping("/{memberId}")
    @ResponseBody
    public Member getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

}
