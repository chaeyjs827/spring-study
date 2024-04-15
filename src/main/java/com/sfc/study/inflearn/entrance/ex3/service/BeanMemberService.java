package com.sfc.study.inflearn.entrance.ex3.service;

import com.sfc.study.inflearn.entrance.ex3.repository.BeanMemberRepository;

public class BeanMemberService {

    private BeanMemberRepository beanMemberRepository;

    public BeanMemberService(
            BeanMemberRepository beanMemberRepository
    ) {
        this.beanMemberRepository = beanMemberRepository;
    }

}
