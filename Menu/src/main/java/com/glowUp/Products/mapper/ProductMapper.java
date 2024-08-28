package com.italianrestaurant.Menu.mapper;

import com.italianrestaurant.Menu.dto.ProductDto;
import com.italianrestaurant.Menu.entity.Product;

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

    public static ProductDto mapToProductDto(Product menuItem, ProductDto ProductDto){
        ProductDto.setName(menuItem.getName());
        ProductDto.setDescription(menuItem.getDescription());
        ProductDto.setImageUrl(menuItem.getImageUrl());
        ProductDto.setCategoryId(menuItem.getCategoryId());
        ProductDto.setSubcategoryId(menuItem.getSubcategoryId());
        ProductDto.setPrice(menuItem.getPrice());
        return ProductDto;
    }
}
