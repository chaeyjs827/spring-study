package com.sfc.study.cqrs.post.event;

public class PostDeletedEvent {
    private final Long postId;

    public PostDeletedEvent(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}