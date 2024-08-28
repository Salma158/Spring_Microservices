package com.italianrestaurant.Menu.service.impl;

import com.italianrestaurant.Menu.dto.ProductDto;
import com.italianrestaurant.Menu.entity.Product;
import com.italianrestaurant.Menu.exception.ResourceNotFoundException;
import com.italianrestaurant.Menu.mapper.ProductMapper;
import com.italianrestaurant.Menu.repository.ProductRepository;
import com.italianrestaurant.Menu.service.IProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsService implements IProductsService {

    private ProductRepository productRepository;
    @Override
    public void createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto, new Product());
        productRepository.save(product);
    }

    @Override
    public ProductDto fetchProduct(Long id) {
        Product menuItem= productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Menu Item", "Id", id));
        ProductDto ProductDto = ProductMapper.mapToProductDto(menuItem, new ProductDto());
        return ProductDto;
    }

    @Override
    public List<ProductDto> fetchProducts() {
        List<Product> MenuItems = productRepository.findAll();
        return MenuItems.stream()
                .map((menuItem) -> ProductMapper.mapToProductDto(menuItem, new ProductDto()))
                .collect(Collectors.toList());

    }

    @Override
    public void updateProduct(ProductDto ProductDto, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item", "Id", id));
        ProductMapper.mapToProduct(ProductDto, product);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item", "Id", id));
        productRepository.deleteById(id);
    }
}
