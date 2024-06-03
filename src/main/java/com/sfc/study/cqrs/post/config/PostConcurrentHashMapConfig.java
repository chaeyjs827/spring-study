package com.sfc.study.cqrs.post.config;

import com.sfc.study.cqrs.post.entity.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class PostConcurrentHashMapConfig {

    @Bean
    public ConcurrentHashMap<Long, Post> postStore() {
        return new ConcurrentHashMap<>();
    }

}
