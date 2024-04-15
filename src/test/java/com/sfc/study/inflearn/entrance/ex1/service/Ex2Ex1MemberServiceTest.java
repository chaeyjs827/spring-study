package com.sfc.study.inflearn.entrance.ex1.service;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Ex1Member;
import com.sfc.study.inflearn.entrance.ex1.structure.repository.Ex1MemoryEx1MemberRepository;
import com.sfc.study.inflearn.entrance.ex1.structure.service.Ex1MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class Ex2Ex1MemberServiceTest {

    Ex1MemberService ex1MemberService = new Ex1MemberService();
    Ex1MemoryEx1MemberRepository memoryMemberRepository = new Ex1MemoryEx1MemberRepository();

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void test_join() {
        // given
        Ex1Member ex1Member = new Ex1Member();
        ex1Member.setName("Hello");

        Long saveId = ex1MemberService.join(ex1Member);


        // when
        // then
        Ex1Member foundEx1Member = ex1MemberService.findOne(saveId).get();
        Assertions.assertThat(ex1Member.getName()).isEqualTo(foundEx1Member.getName());
    }


    @Test
    public void duplicatedMemberExceptino() {
        // given
        Ex1Member ex1Member = new Ex1Member();
        ex1Member.setName("spring1");

        Ex1Member ex1Member2 = new Ex1Member();
        ex1Member.setName("spring1");

        // when
        ex1MemberService.join(ex1Member);
        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalStateException.class, () -> ex1MemberService.join(ex1Member2)
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