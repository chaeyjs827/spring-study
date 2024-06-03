package com.sfc.study.cqrs.post.event;

import com.sfc.study.cqrs.post.entity.Post;

public class PostUpdatedEvent {
    private final Post post;

    public PostUpdatedEvent(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
