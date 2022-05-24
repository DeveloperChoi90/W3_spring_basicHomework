package com.sparta.w3_homework.models;

import lombok.Getter;

@Getter
public class PostsRequestDto {
    // userName, pw, title, content
    private String userName;
    private String password;
    private String title;
    private String content;
}