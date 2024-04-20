package com.sfc.study.inflearn.entrance.ex4.service;

import com.sfc.study.inflearn.entrance.ex4.domain.Ex4Member;
import com.sfc.study.inflearn.entrance.ex4.repository.Ex4JdbcTemplateEx4MemberRepository;
import com.sfc.study.inflearn.entrance.ex4.repository.Ex4MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ex4MemberService {

    private final Ex4MemberRepository ex4MemberRepository;

    public Ex4MemberService(
            Ex4JdbcTemplateEx4MemberRepository jdbcTemplateMemberRepository
    ) {
        this.ex4MemberRepository = jdbcTemplateMemberRepository;
    }

    public void save(Ex4Member member) {

        ex4MemberRepository.save(member);
    }

    public List<Ex4Member> getMemberList() {
        return ex4MemberRepository.findAll();
    }

    public Ex4Member getMember(Long memberId) {
        return ex4MemberRepository.findById(memberId).orElse(null);
    }

}
