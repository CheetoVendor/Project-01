package com.revatureproject01.project01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Post;
import com.revatureproject01.project01.repository.CommentRepository;
import com.revatureproject01.project01.repository.LikeRepository;
import com.revatureproject01.project01.repository.PostRepository;

import DTO.PostDTO;

@Service
public class PostService {
    PostRepository postRepository;
    CommentRepository commentRepository;
    LikeRepository likeRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Creates a post
    public PostDTO createPost(Post post) {
        Post p = postRepository.save(post);

        PostDTO saved = new PostDTO(p);
        return saved;
    }

    // Gets post by user
    public List<PostDTO> getPostByUser(Account account) {
        List<Post> posts = postRepository.findByPostedBy(account);
        List<PostDTO> dtos = new ArrayList<>();

        for (Post p : posts) {
            dtos.add(new PostDTO(p));
        }
        return dtos;
    }

    // Gets all posts
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        List<PostDTO> dtos = new ArrayList<>();

        for (Post post : posts) {
            dtos.add(new PostDTO(post));
        }
        return dtos;
    }

    // deletes a post by its id
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

    // update post
    public PostDTO updatePostById(Integer id, Post post) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            Post update = optional.get();
            update.setPostText(post.getPostText());
            update.setImageUrl(post.getImageUrl());
            update.setVideoUrl(post.getVideoUrl());
            postRepository.save(update);

            return new PostDTO(update);
        } else {
            return null;
        }
    }

}
