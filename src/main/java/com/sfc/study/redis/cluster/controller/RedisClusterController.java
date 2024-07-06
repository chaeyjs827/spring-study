//package com.sfc.study.redis.cluster.controller;
//
//import com.sfc.study.redis.cluster.service.RedisClusterService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RedisClusterController {
//
//    private final RedisClusterService redisClusterService;
//
//    public RedisClusterController(RedisClusterService redisClusterService) {
//        this.redisClusterService = redisClusterService;
//    }
//
//    @PostMapping("/save")
//    public String saveData(@RequestParam String key, @RequestParam String value) {
//        redisClusterService.saveData(key, value);
//        return "Data saved";
//    }
//
//    @GetMapping("/get")
//    public String getData(@RequestParam String key) {
//        return redisClusterService.getData(key);
//    }
//}
