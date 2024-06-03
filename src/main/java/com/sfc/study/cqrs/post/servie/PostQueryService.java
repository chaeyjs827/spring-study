package com.sfc.study.cqrs.post.servie;

import com.sfc.study.cqrs.post.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class PostQueryService {
    private final ConcurrentHashMap<Long, Post> postStore;

    public PostQueryService(ConcurrentHashMap<Long, Post> postStore) {
        this.postStore = postStore;
    }

    public List<Post> getAllPosts() {
        return postStore.values().stream().collect(Collectors.toList());
    }

    public Post getPostById(Long id) {
        Post post = postStore.get(id);
        if (post == null) {
            throw new RuntimeException("Post not found");
        }
        return post;
    }

    public void createPost(Long id, String title, String content) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        postStore.put(id, post);
    }

    public void updatePost(Long id, String title, String content) {
        Post post = postStore.get(id);
        if (post == null) {
            throw new RuntimeException("Post not found");
        }
        post.setTitle(title);
        post.setContent(content);
        postStore.put(id, post);
    }

    public void deletePost(Long id) {
        postStore.remove(id);
    }
}

