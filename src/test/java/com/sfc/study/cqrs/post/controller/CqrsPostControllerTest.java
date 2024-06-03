package com.sfc.study.cqrs.post.controller;

import com.sfc.study.cqrs.post.entity.Post;
import com.sfc.study.cqrs.post.servie.PostCommandService;
import com.sfc.study.cqrs.post.servie.PostQueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CqrsPostControllerTest {

    @Autowired
    private PostCommandService postCommandService;

    @Autowired
    private PostQueryService postQueryService;

    @Test
    public void testCreateAndQueryPost() {
        Post post = postCommandService.createPost("Title1", "Content1");
        assertThat(post).isNotNull();

        Post queriedPost = postQueryService.getPostById(post.getId());
        assertThat(queriedPost.getTitle()).isEqualTo("Title1");
        assertThat(queriedPost.getContent()).isEqualTo("Content1");
    }

    @Test
    public void testUpdateAndQueryPost() {
        Post post = postCommandService.createPost("Title2", "Content2");
        assertThat(post).isNotNull();

        postCommandService.updatePost(post.getId(), "UpdatedTitle", "UpdatedContent");

        Post queriedPost = postQueryService.getPostById(post.getId());
        assertThat(queriedPost.getTitle()).isEqualTo("UpdatedTitle");
        assertThat(queriedPost.getContent()).isEqualTo("UpdatedContent");
    }

    @Test
    public void testDeleteAndQueryPost() {
        Post post = postCommandService.createPost("Title3", "Content3");
        assertThat(post).isNotNull();

        postCommandService.deletePost(post.getId());

        Throwable thrown = catchThrowable(() -> postQueryService.getPostById(post.getId()));
        assertThat(thrown).isInstanceOf(RuntimeException.class).hasMessageContaining("Post not found");
    }
}