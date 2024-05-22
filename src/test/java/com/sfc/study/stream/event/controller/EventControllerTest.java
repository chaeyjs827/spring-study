package com.sfc.study.stream.event.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_get_event_list_by_api_server() {
//        mockMvc.perform(get("/api/v1/event"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
    }

}