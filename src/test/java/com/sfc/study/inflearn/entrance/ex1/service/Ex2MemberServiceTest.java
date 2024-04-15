package com.sfc.study.inflearn.entrance.ex1.service;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Member;
import com.sfc.study.inflearn.entrance.ex1.structure.repository.MemoryMemberRepository;
import com.sfc.study.inflearn.entrance.ex1.structure.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class Ex2MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void test_join() {
        // given
        Member member = new Member();
        member.setName("Hello");

        Long saveId = memberService.join(member);


        // when
        // then
        Member foundMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(foundMember.getName());
    }


    @Test
    public void duplicatedMemberExceptino() {
        // given
        Member member = new Member();
        member.setName("spring1");

        Member member2 = new Member();
        member.setName("spring1");

        // when
        memberService.join(member);
        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalStateException.class, () -> memberService.join(member2)
        );

        // then


    }

    @Test
    void test_find_members() {
    }

    @Test
    void test_find_one() {
    }
}