package com.sparta.w3_homework.controller;

import com.sparta.w3_homework.models.PostsUpdateDto;
import com.sparta.w3_homework.models.Posts;
import com.sparta.w3_homework.models.PostsRepository;
import com.sparta.w3_homework.models.PostsRequestDto;
import com.sparta.w3_homework.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsRepository PostsRepository;
    private final PostsService PostsService;

    // 게시글 작성 API
    @PostMapping("/api/posts")
    public Posts createPosts(@RequestBody PostsRequestDto requestDto){
        Posts posts = new Posts(requestDto);
        return PostsRepository.save(posts);
    }

    // 전체 게시글 조회 API
    @GetMapping("/api/posts")
    public List<PostsRequestDto> readPosts(){
        return PostsRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/posts/{id}/detail")
    public Posts readDetail(@PathVariable Long id){
        return PostsRepository.findById(id).get();  // controller 에서 DB에 바로 접근하여 DB를 가져와도 되는건가?
    }

    // 특정 게시글 수정 API
    @PutMapping("/api/posts/{id}")
    public boolean updatePosts(@PathVariable Long id, @RequestBody PostsUpdateDto postUpdateDto) {
        return PostsService.update(id, postUpdateDto);
    }

    // 특정 게시글 삭제 API
    @DeleteMapping("/api/posts/{id}")
    public boolean deletePosts(@PathVariable Long id, @RequestBody PostsUpdateDto postsUpdateDto) {
        return PostsService.delete(id, postsUpdateDto);
    }


}
