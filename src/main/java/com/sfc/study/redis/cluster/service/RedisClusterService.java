///*
//package com.sfc.study.redis.cluster.service;
//
//import org.redisson.api.RBucket;
//import org.redisson.api.RedissonClient;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RedisClusterService {
//
//    private final RedissonClient redissonClient;
//
//    public RedisClusterService(RedissonClient redissonClient) {
//        this.redissonClient = redissonClient;
//    }
//
//    public void saveData(String key, String value) {
//        RBucket<String> bucket = redissonClient.getBucket(key);
//        bucket.set(value);
//    }
//
//    public String getData(String key) {
//        RBucket<String> bucket = redissonClient.getBucket(key);
//        return bucket.get();
//    }
//}
//*/
