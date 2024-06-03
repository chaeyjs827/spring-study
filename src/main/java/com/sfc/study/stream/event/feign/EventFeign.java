package com.sfc.study.stream.event.feign;

import com.sfc.study.stream.config.FeignConfig;
import com.sfc.study.stream.event.dto.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "bunjang-event-api",
        url = "https://s3.ap-northeast-2.amazonaws.com/bunjang-interview/events.json",
        configuration = FeignConfig.class
)
public interface EventFeign {

    @RequestMapping(method = RequestMethod.GET)
    List<Event> getEventList();

}
