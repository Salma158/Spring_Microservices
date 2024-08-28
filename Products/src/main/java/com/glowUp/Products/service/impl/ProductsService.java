package com.glowUp.Products.service.impl;

import com.glowUp.Products.dto.ProductDto;
import com.glowUp.Products.exception.ResourceNotFoundException;
import com.glowUp.Products.repository.ProductRepository;
import com.glowUp.Products.service.IProductsService;
import com.glowUp.Products.entity.Product;
import com.glowUp.Products.mapper.ProductMapper;
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
        Product product= productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("product", "Id", id));
        ProductDto ProductDto = ProductMapper.mapToProductDto(product, new ProductDto());
        return ProductDto;
    }

    @Override
    public List<ProductDto> fetchProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map((product) -> ProductMapper.mapToProductDto(product, new ProductDto()))
                .collect(Collectors.toList());

    }

    @Override
    public void updateProduct(ProductDto ProductDto, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
        ProductMapper.mapToProduct(ProductDto, product);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }
}
