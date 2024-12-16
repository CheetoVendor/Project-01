package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Post;
import com.revatureproject01.project01.service.PostService;

@RestController
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Handler to get all posts
    @GetMapping("/posts")
    public ResponseEntity getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.status(200).body(posts);
    }

    // handler to add a post
    @PostMapping("/posts")
    public ResponseEntity createPost(@RequestBody Post post) {
        return ResponseEntity.status(200).body(post);
    }
}
