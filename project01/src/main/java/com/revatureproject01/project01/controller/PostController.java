package com.revatureproject01.project01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Post;
import com.revatureproject01.project01.service.PostService;

@CrossOrigin(origins = "http://localhost:3000")
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

    // Handler to get all posts from user
    @GetMapping("/accounts/{accountId}/posts")
    public ResponseEntity getPostsByUser(@PathVariable Account accountId) {
        List<Post> posts = postService.getPostByUser(accountId);
        return ResponseEntity.status(200).body(posts);
    }

    // handler to add a post
    @PostMapping("/posts")
    public ResponseEntity createPost(@RequestBody Post post) {
        Post posted = postService.createPost(post);
        return ResponseEntity.status(200).body(posted);
    }

    // handler to delete post
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity deletePost(@PathVariable Integer postId) {
        int rows = postService.deletePostById(postId);
        if (rows > 0) {
            return ResponseEntity.status(200).body(rows);
        } else {
            return ResponseEntity.status(200).body("");
        }
    }

    // TODO - Handler to edit post
    @PatchMapping("/posts/{postId}")
    public ResponseEntity updatePost(@PathVariable Integer postId, @RequestBody Post post) {
        Post posted = postService.updatePostById(postId, post);
        if (posted != null) {
            return ResponseEntity.status(200).body(posted);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }
}
