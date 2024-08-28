package com.italianrestaurant.Menu.controller;

import com.italianrestaurant.Menu.constants.ProductConstants;
import com.italianrestaurant.Menu.dto.ErrorResponseDto;
import com.italianrestaurant.Menu.dto.ProductDto;
import com.italianrestaurant.Menu.dto.ResponseDto;
import com.italianrestaurant.Menu.service.IProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for products in the ecommerce",
        description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE products details"
)
@RestController
@RequestMapping(value = "/api/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductsController {

    private IProductsService iProductsService;

    @Operation(
            summary = "Create Products REST API",
            description = "REST API to create new Products"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping
    public ResponseEntity<ResponseDto> createProduct(@RequestBody @Valid ProductDto productDto){
        iProductsService.createProduct(productDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ProductConstants.STATUS_201, ProductConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Product Details REST API",
            description = "REST API to fetch Product details based on the Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> fetchProduct(@RequestParam Long id){
        ProductDto ProductDto = iProductsService.fetchProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(ProductDto);
    }

    @Operation(
            summary = "Fetch Menu Items Details REST API",
            description = "REST API to fetch All Products details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping
    public ResponseEntity<List<ProductDto>> fetchProducts(){
        List<ProductDto> ProductDtos = iProductsService.fetchProducts();
        return ResponseEntity.status(HttpStatus.OK).body(ProductDtos);
    }

    @Operation(
            summary = "Update Product Details REST API",
            description = "REST API to update Product based on the Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateProduct(@RequestBody ProductDto ProductDto, @RequestParam Long id) {
        iProductsService.updateProduct(ProductDto, id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ProductConstants.STATUS_200, ProductConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Delete Product REST API",
            description = "REST API to delete Product based the Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteMenuItem(@RequestParam Long id) {
        iProductsService.deleteProduct(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ProductConstants.STATUS_200, ProductConstants.MESSAGE_200));
    }


}
