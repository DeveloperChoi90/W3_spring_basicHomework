package com.sparta.navershopprac.service;

import com.sparta.navershopprac.models.Product;
import com.sparta.navershopprac.models.ProductMypriceRequestDto;
import com.sparta.navershopprac.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto mypriceRequestDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        product.update(mypriceRequestDto);
        return id;
    }
}
