package com.sfc.study.inflearn.basic.core.member;

import org.springframework.stereotype.Service;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
