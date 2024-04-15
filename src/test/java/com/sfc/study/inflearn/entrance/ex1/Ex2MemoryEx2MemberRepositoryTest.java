package com.sfc.study.inflearn.entrance.ex1;

import com.sfc.study.inflearn.entrance.ex1.structure.domain.Ex1Member;
import com.sfc.study.inflearn.entrance.ex1.structure.repository.Ex1MemoryEx1MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class Ex2MemoryEx2MemberRepositoryTest {

    Ex1MemoryEx1MemberRepository repository = new Ex1MemoryEx1MemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Ex1Member ex1Member = new Ex1Member();
        ex1Member.setName("spring");

        repository.save(ex1Member);

        Ex1Member result = repository.findById(ex1Member.getId()).get();
        Assertions.assertThat(ex1Member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Ex1Member ex1Member1 = new Ex1Member();
        ex1Member1.setName("spring1");
        repository.save(ex1Member1);


        Ex1Member ex1Member2 = new Ex1Member();
        ex1Member2.setName("spring2");
        repository.save(ex1Member2);

        Ex1Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(ex1Member1);
    }

    @Test
    public void findAll() {
        Ex1Member ex1Member1 = new Ex1Member();
        ex1Member1.setName("spring1");
        repository.save(ex1Member1);

        Ex1Member ex1Member2 = new Ex1Member();
        ex1Member2.setName("spring2");
        repository.save(ex1Member2);

        List<Ex1Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);

    }

}
