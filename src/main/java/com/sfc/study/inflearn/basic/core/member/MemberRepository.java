package com.sfc.study.inflearn.basic.core.member;

import org.springframework.stereotype.Repository;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);

}
