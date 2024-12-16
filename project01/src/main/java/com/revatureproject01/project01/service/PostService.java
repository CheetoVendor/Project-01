package com.revatureproject01.project01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Comment;
import com.revatureproject01.project01.entity.Like;
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

    // TODO - add comment to a post
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // TODO - add a like/react to a post
    public Like addReaction(Like like) {
        return likeRepository.save(like);
    }

    // TODO - get posts by user id

    // TODO - get likes by post id

    // TODO - get comments by post id

    // TODO - search posts
}
