package com.sfc.study.inflearn.entrance.ex1.structure.repository;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Ex1Member;

import java.util.List;
import java.util.Optional;

public interface Ex1MemberRepository {
    Ex1Member save(Ex1Member ex1Member);
    Optional<Ex1Member> findById(Long id);
    Optional<Ex1Member> findByName(String name);
    List<Ex1Member> findAll();
}
