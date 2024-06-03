package com.sfc.study.cqrs.post.servie;

import com.sfc.study.cqrs.post.entity.Post;
import com.sfc.study.cqrs.post.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostCommandService {
    private final ConcurrentHashMap<Long, Post> postStore;
    private final AtomicLong idGenerator = new AtomicLong();
    private final EventPublisher eventPublisher;

    public PostCommandService(ConcurrentHashMap<Long, Post> postStore, EventPublisher eventPublisher) {
        this.postStore = postStore;
        this.eventPublisher = eventPublisher;
    }

    public Post createPost(String title, String content) {
        Long id = idGenerator.incrementAndGet();
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        postStore.put(id, post);
        eventPublisher.publishPostCreatedEvent(post);
        return post;
    }

    public Post updatePost(Long id, String title, String content) {
        Post post = postStore.get(id);
        if (post == null) {
            throw new RuntimeException("Post not found");
        }
        post.setTitle(title);
        post.setContent(content);
        postStore.put(id, post);
        eventPublisher.publishPostUpdatedEvent(post);
        return post;
    }

    public void deletePost(Long id) {
        postStore.remove(id);
        eventPublisher.publishPostDeletedEvent(id);
    }
}
