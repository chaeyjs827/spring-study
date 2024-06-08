package com.sfc.study.cqrs.post.controller;

import com.sfc.study.cqrs.post.entity.Post;
import com.sfc.study.cqrs.post.servie.PostQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/posts")
public class PostQueryController {
    @Autowired
    private PostQueryService postQueryService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postQueryService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postQueryService.getPostById(id);
    }
}
