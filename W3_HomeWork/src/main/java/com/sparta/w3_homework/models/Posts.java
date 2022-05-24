package com.sparta.w3_homework.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Posts(PostsRequestDto requestDto){
        this.userName = requestDto.getUserName();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(PostsUpdateDto updateDto){
        this.userName = updateDto.getUserName();
        this.title = updateDto.getTitle();
        this.content = updateDto.getContent();
    }
}
