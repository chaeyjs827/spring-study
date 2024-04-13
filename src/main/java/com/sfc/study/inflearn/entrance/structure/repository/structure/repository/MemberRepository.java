package com.sfc.study.inflearn.entrance.structure.repository.structure.repository;

import com.sfc.study.inflearn.entrance.structure.repository.structure.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
