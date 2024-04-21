package com.sfc.study.inflearn.basic.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
