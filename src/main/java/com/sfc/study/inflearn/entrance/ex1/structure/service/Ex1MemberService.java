package com.sfc.study.inflearn.entrance.ex1.structure.service;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Ex1Member;
import com.sfc.study.inflearn.entrance.ex1.structure.repository.Ex1MemberRepository;
import com.sfc.study.inflearn.entrance.ex1.structure.repository.Ex1MemoryEx1MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Ex1MemberService {

    private final Ex1MemberRepository ex1MemberRepository = new Ex1MemoryEx1MemberRepository();

    public Long join(Ex1Member ex1Member) {
        validateDuplicateMember(ex1Member);

        ex1MemberRepository.save(ex1Member);
        return ex1Member.getId();
    }

    private void validateDuplicateMember(Ex1Member ex1Member) {
        ex1MemberRepository.findByName(ex1Member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    public List<Ex1Member> findMembers() {
        return ex1MemberRepository.findAll();
    }

    public Optional<Ex1Member> findOne(Long memberId) {
        return ex1MemberRepository.findById(memberId);
    }

}
