package com.sfc.study.cqrs.post.event;

import com.sfc.study.cqrs.post.entity.Post;

public class PostCreatedEvent {
    private final Post post;

    public PostCreatedEvent(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}