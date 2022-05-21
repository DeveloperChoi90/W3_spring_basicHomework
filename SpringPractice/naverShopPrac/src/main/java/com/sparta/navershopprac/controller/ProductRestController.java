package com.sparta.navershopprac.controller;

import com.sparta.navershopprac.models.Product;
import com.sparta.navershopprac.models.ProductRepository;
import com.sparta.navershopprac.models.ProductRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // ProductRestController를 사용할 땐 반드시 ProductRepository가 있어야 함을 명시
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;


    @GetMapping("/api/products")
    public List<Product> readProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }
}
