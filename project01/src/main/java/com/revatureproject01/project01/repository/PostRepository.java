package com.revatureproject01.project01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByPostedBy(Account account);

    List<Post> findByPostTextContainingIgnoreCase(String postText);
}
