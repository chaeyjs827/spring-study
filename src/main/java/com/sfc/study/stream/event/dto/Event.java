package com.sfc.study.stream.event.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    private Long id;
    private String type;
    private Actor actor;

}
