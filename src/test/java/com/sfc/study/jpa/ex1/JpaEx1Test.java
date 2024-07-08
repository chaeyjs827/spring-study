package com.sfc.study.jpa.ex1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaEx1Test {

    @Autowired
    private JpaEx1 jpaEx1;

    @Test
    void test_case1() {
        jpaEx1.case1();
    }

    @Test
    void test_process_flight() {
        jpaEx1.processFlight();
    }
}