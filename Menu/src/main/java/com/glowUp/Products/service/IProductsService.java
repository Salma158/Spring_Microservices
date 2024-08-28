package com.italianrestaurant.Menu.service;

import com.italianrestaurant.Menu.dto.ProductDto;

import java.util.List;

public interface IProductsService {
    void createProduct(ProductDto ProductDto);
    ProductDto fetchProduct(Long id);
    List<ProductDto> fetchProducts();
    void updateProduct(ProductDto ProductDto, Long id);
    void deleteProduct(Long id);
}
