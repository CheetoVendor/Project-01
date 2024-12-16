package com.revatureproject01.project01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatureproject01.project01.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

}
