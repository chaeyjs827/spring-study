package com.sfc.study.inflearn.entrance.ex4.repository;

import com.sfc.study.inflearn.entrance.ex4.domain.Ex4Member;

import java.util.List;
import java.util.Optional;

public interface Ex4MemberRepository {
    Ex4Member save(Ex4Member member);
    Optional<Ex4Member> findById(Long id);
    Optional<Ex4Member> findByName(String name);
    List<Ex4Member> findAll();
}
