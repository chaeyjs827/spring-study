package com.sfc.study.cqrs.post.publisher;

import com.sfc.study.cqrs.post.entity.Post;
import com.sfc.study.cqrs.post.event.PostCreatedEvent;
import com.sfc.study.cqrs.post.event.PostDeletedEvent;
import com.sfc.study.cqrs.post.event.PostUpdatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {
    private final ApplicationEventPublisher publisher;

    public EventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishPostCreatedEvent(Post post) {
        publisher.publishEvent(new PostCreatedEvent(post));
    }

    public void publishPostUpdatedEvent(Post post) {
        publisher.publishEvent(new PostUpdatedEvent(post));
    }

    public void publishPostDeletedEvent(Long postId) {
        publisher.publishEvent(new PostDeletedEvent(postId));
    }
}
