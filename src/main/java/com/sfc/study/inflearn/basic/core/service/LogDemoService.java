package com.sfc.study.inflearn.basic.core.service;

import com.sfc.study.inflearn.basic.core.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
public class LogDemoService {

    private final MyLogger myLogger;

    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String testId) {
        myLogger.log("service log : " + testId);
    }
}
