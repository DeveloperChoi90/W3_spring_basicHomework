package com.sparta.w3_homework.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostsRequestDto {
    // userName, pw, title, content
    private final String userName;
    private final String password;
    private final String title;
    private final String content;
}