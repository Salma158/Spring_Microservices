package com.glowUp.Products.service;

import com.glowUp.Products.dto.ProductDto;

import java.util.List;

public interface IProductsService {
    void createProduct(ProductDto ProductDto);
    ProductDto fetchProduct(Long id);
    List<ProductDto> fetchProducts();
    void updateProduct(ProductDto ProductDto, Long id);
    void deleteProduct(Long id);
}
