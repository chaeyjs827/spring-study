package com.sfc.study.inflearn.entrance.ex4.repository;

import com.sfc.study.inflearn.entrance.ex4.domain.Ex4Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class Ex4MemoryEx4MemberRepository implements Ex4MemberRepository {

    private static Map<Long, Ex4Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Ex4Member save(Ex4Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Ex4Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Ex4Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Ex4Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
