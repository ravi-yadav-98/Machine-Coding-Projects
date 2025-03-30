package com.productservices.productservices.services;

import com.productservices.productservices.dtos.FakeStoreDto;
import com.productservices.productservices.dtos.GenricProductDto;

import java.util.List;

public interface ProductService {
    GenricProductDto getProductById(Long id);
    List<GenricProductDto> getAllProducts();
    GenricProductDto deleteProductById(Long Id);
    void updateProductById();
    GenricProductDto createProduct(GenricProductDto genricProductDto);

}
