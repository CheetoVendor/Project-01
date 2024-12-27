package com.revatureproject01.project01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Comment;
import com.revatureproject01.project01.repository.AccountRepository;
import com.revatureproject01.project01.repository.CommentRepository;

import DTO.AccountDTO;
import DTO.CommentDTO;

@Service
public class CommentService {
    CommentRepository commentRepository;
    AccountRepository accountRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, AccountRepository accountRepository) {
        this.commentRepository = commentRepository;
        this.accountRepository = accountRepository;
    }

    // Adds a comment
    public CommentDTO addComment(Comment comment) {
        CommentDTO comm = new CommentDTO(commentRepository.save(comment));
        Optional<Account> optional = accountRepository.findById(comment.getPostedBy().getAccountId());
        if (optional.isPresent()) {
            comm.setPostedBy(new AccountDTO(optional.get()));
        }
        return comm;
    }

    // Removes a comment
    public int removeComment(Comment comment) {
        Optional<Comment> optionalComment = commentRepository.findById(comment.getCommentId());
        if (optionalComment.isPresent()) {
            Comment rm = optionalComment.get();
            commentRepository.delete(rm);
            return 1;
        } else {
            return 0;
        }
    }

    // Gets the comments on a post by post id
    public List<CommentDTO> getCommentsByPostId(Integer postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentDTO> commentDTOs = new ArrayList<>();

        for (Comment comment : comments) {
            commentDTOs.add(new CommentDTO(comment));
        }

        return commentDTOs;
    }

    // updates a comment
    public CommentDTO updateComment(Comment comment) {
        CommentDTO saved = new CommentDTO(commentRepository.save(comment));
        return saved;
    }
}
