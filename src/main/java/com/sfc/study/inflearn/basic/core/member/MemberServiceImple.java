package com.sfc.study.inflearn.basic.core.member;

import org.springframework.stereotype.Component;

@Component
public class MemberServiceImple implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImple(
            MemberRepository memberRepository
    ) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
