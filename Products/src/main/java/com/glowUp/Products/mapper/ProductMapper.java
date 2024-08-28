package com.glowUp.Products.mapper;

import com.glowUp.Products.dto.ProductDto;
import com.glowUp.Products.entity.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductDto ProductDto, Product Product){
        Product.setName(ProductDto.getName());
        Product.setDescription(ProductDto.getDescription());
        Product.setImageUrl(ProductDto.getImageUrl());
        Product.setCategoryId(ProductDto.getCategoryId());
        Product.setSubcategoryId(ProductDto.getSubcategoryId());
        Product.setPrice(ProductDto.getPrice());
        return Product;
    }

    public static ProductDto mapToProductDto(Product product, ProductDto ProductDto){
        ProductDto.setName(product.getName());
        ProductDto.setDescription(product.getDescription());
        ProductDto.setImageUrl(product.getImageUrl());
        ProductDto.setCategoryId(product.getCategoryId());
        ProductDto.setSubcategoryId(product.getSubcategoryId());
        ProductDto.setPrice(product.getPrice());
        return ProductDto;
    }
}
