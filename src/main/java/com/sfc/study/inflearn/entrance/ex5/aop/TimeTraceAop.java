package com.sfc.study.inflearn.entrance.ex5.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TimeTraceAop {

    /**
     * 1. @Aspect 어노테이션 사용
     * 2. 로직 개발
     * 3. Bean 등록 (@Component)
     * 4. @Around 사용 (어디에 사용할지 타겟팅을 해줄 수 있음)
     */
    @Around("execution(* com.sfc.study.inflearn.entrance..*(..))")
//    @Around("execution(* com.sfc.study.inflearn.entrance.ex5.controller..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.debug("[START] : {}", joinPoint.toShortString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            log.debug("[END] : {} {}ms", joinPoint.toString(), timeMs);
        }
    }

}
