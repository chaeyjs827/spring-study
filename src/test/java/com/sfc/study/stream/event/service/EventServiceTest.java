package com.sfc.study.stream.event.service;

import com.sfc.study.stream.event.dto.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EventServiceTest {

    @Autowired
    EventService eventService;

    @Test
    public void test_get_event_list_by_api_server() {
        List<Event> list = eventService.getEventList();
        Assertions.assertNotNull(list);
    }


}