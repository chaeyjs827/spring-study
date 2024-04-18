package com.sfc.study.inflearn.entrance.ex1;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/inflearn/entrance")
@RestController
public class HelloController {

    @GetMapping("/api-test")
    public String getInflearnEntranceApiTest() {
        return "test";
    }

    @GetMapping("/api-test-body")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("/api-test-hello")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
