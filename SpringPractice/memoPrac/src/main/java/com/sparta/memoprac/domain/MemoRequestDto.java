package com.sparta.memoprac.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class MemoRequestDto {
    private String username;
    private String contents;
}
