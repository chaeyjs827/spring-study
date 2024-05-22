package com.sfc.study.stream.event.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Events {

    private String login;
    private Map<String, Integer> events;

}
