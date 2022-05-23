package com.sparta.navershopprac.controller;

import com.sparta.navershopprac.models.ItemDto;
import com.sparta.navershopprac.utils.NaverShopSearch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query){ // RequestParam -> ?뒤의 파라미터를 얻기위해서/ ?name 과 변수명이 같아야한다.
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONItem(resultString);
    }
}
