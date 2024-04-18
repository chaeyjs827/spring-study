package com.sfc.study.inflearn.entrance.ex1.structure.repository;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Ex1Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class Ex1MemoryEx1MemberRepository implements Ex1MemberRepository {

    // 실무에서는 동시성 문제가 있어서 concurrent map 을 사용하지만, 예제에선 일단 HashMap으로 사용.
    // 공유되는 자원은 동시성 문제 무조건 고려해야 함!!
    private static Map<Long, Ex1Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Ex1Member save(Ex1Member ex1Member) {
        ex1Member.setId(++sequence);
        store.put(ex1Member.getId(), ex1Member);
        return ex1Member;
    }

    @Override
    public Optional<Ex1Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Ex1Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Ex1Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
