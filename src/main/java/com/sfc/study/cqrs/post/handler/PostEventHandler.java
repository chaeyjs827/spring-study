package com.sfc.study.cqrs.post.handler;

import com.sfc.study.cqrs.post.entity.Post;
import com.sfc.study.cqrs.post.event.PostCreatedEvent;
import com.sfc.study.cqrs.post.event.PostDeletedEvent;
import com.sfc.study.cqrs.post.event.PostUpdatedEvent;
import com.sfc.study.cqrs.post.servie.PostQueryService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PostEventHandler {
    private final PostQueryService postQueryService;

    public PostEventHandler(PostQueryService postQueryService) {
        this.postQueryService = postQueryService;
    }

    @EventListener
    public void handlePostCreatedEvent(PostCreatedEvent event) {
        Post post = event.getPost();
        postQueryService.createPost(post.getId(), post.getTitle(), post.getContent());
    }

    @EventListener
    public void handlePostUpdatedEvent(PostUpdatedEvent event) {
        Post post = event.getPost();
        postQueryService.updatePost(post.getId(), post.getTitle(), post.getContent());
    }

    @EventListener
    public void handlePostDeletedEvent(PostDeletedEvent event) {
        Long postId = event.getPostId();
        postQueryService.deletePost(postId);
    }
}