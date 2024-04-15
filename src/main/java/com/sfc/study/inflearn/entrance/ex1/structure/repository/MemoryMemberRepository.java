package com.sfc.study.inflearn.entrance.ex1.structure.repository;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제가 있어서 concurrent map 을 사용하지만, 예제에선 일단 HashMap으로 사용.
    // 공유되는 자원은 동시성 문제 무조건 고려해야 함!!
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
