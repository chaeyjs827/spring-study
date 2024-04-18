package com.sfc.study.inflearn.entrance.ex4.service;

import com.sfc.study.inflearn.entrance.ex4.domain.Member;
import com.sfc.study.inflearn.entrance.ex4.repository.JdbcTemplateMemberRepository;
import com.sfc.study.inflearn.entrance.ex4.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(
            JdbcTemplateMemberRepository jdbcTemplateMemberRepository
    ) {
        this.memberRepository = jdbcTemplateMemberRepository;
    }

    public void save(Member member) {

        memberRepository.save(member);
    }

    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

}
