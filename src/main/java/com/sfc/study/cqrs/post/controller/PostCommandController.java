package com.sfc.study.cqrs.post.controller;

import com.sfc.study.cqrs.post.entity.Post;
import com.sfc.study.cqrs.post.servie.PostCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commands/posts")
public class PostCommandController {
    @Autowired
    private PostCommandService postCommandService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postCommandService.createPost(post.getTitle(), post.getContent());
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postCommandService.updatePost(id, post.getTitle(), post.getContent());
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postCommandService.deletePost(id);
    }
}
