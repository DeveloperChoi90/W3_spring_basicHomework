package com.sparta.w3_homework.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostsResponseDto {
    private final String userName;
    private final String password;
    private final String title;
    private final String content;
}
