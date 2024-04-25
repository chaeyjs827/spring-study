package com.sfc.study.inflearn.basic.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberServiceImple(memberRepository);

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member member2 = new Member(2L, "memberB", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
//        assertThat(member2).isEqualTo(findMember);
    }

}