package com.sfc.study.inflearn.entrance.ex1.structure.repository;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
