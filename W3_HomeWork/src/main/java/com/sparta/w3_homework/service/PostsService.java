package com.sparta.w3_homework.service;

import com.sparta.w3_homework.models.Posts;
import com.sparta.w3_homework.models.PostsRepository;
import com.sparta.w3_homework.models.PostsUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository PostsRepository;

    @Transactional
    public boolean update(Long id, PostsUpdateDto postsUpdateDto){ // pw를 보내야 하나?
        Posts posts = PostsRepository.findById(id).orElseThrow();
        if(postsUpdateDto.getPassword().equals(posts.getPassword())){
            posts.update(postsUpdateDto);
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public boolean delete(Long id, PostsUpdateDto postsUpdateDto){ // pw를 보내야 하나?
        Posts posts = PostsRepository.findById(id).orElseThrow();
        if(postsUpdateDto.getPassword().equals(posts.getPassword())){
            PostsRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}