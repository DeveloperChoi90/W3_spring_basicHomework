package com.sparta.w3_homework.service;

import com.sparta.w3_homework.models.Posts;
import com.sparta.w3_homework.models.PostsRepository;
import com.sparta.w3_homework.models.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository PostsRepository;

    @Transactional
    public boolean update(Long id, PostsResponseDto postsResponseDto){
        Posts posts = PostsRepository.findById(id).orElseThrow();
        if(postsResponseDto.getPassword().equals(posts.getPassword())){
            posts.update(postsResponseDto);
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public boolean delete(Long id, PostsResponseDto postsResponseDto){
        Posts posts = PostsRepository.findById(id).orElseThrow();
        if(postsResponseDto.getPassword().equals(posts.getPassword())){
            PostsRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}