package com.revatureproject01.project01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Post;
import com.revatureproject01.project01.repository.CommentRepository;
import com.revatureproject01.project01.repository.LikeRepository;
import com.revatureproject01.project01.repository.PostRepository;

@Service
public class PostService {
    PostRepository postRepository;
    CommentRepository commentRepository;
    LikeRepository likeRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // TODO - Create a post
    public Post createPost(Post post) {
        // TODO - add checks later
        return postRepository.save(post);
    }

    // TODO - get posts by user id
    public List<Post> getPostByUserId(Integer id) {
        return postRepository.findByPostedBy(id);
    }

    // TODO - Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Integer deletePostById(Integer id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            Post post = optional.get();
            postRepository.delete(post);
            return 1;
        } else {
            return 0;
        }
    }

    // TODO - update post
    public Post updatePostById(Integer id, Post post) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            Post update = optional.get();
            update.setPostText(post.getPostText());
            update.setImageUrl(post.getImageUrl());
            update.setVideoUrl(post.getVideoUrl());
            postRepository.save(update);
            return update;
        } else {
            return null;
        }
    }
    // TODO - search posts

}
