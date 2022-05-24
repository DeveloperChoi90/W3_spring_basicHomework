package com.sparta.w3_homework.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findAllByOrderByModifiedAtDesc();
}
