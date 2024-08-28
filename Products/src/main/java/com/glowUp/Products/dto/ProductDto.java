package com.glowUp.Products.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(
        name = "Product",
        description = "Schema to hold Product information"
)
public class ProductDto {

    @NotBlank(message = "Name is required")
    @Schema(
            description = "Name of Product", example = "cosrx snail moisturizer"
    )
    private String name;

    @NotBlank(message = "Description is required")
    @Schema(
            description = "Description of the Product", example = "cosrx snail moisturizer is one of the best sellers."
    )
    private String description;

    @Schema(
            description = "Image of the Product"
    )
    private String imageUrl;

    @NotNull(message = "CategoryId is required")
    @Schema(
            description = "category of the Product, like : moisturizers", example = "1"
    )
    private Long categoryId;

    @NotNull(message = "SubcategoryId is required")
    @Schema(
            description = "sub category of the Product", example = "5"
    )
    private Long subcategoryId;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Schema(
            description = "The price of the Product", example = "300"
    )
    private Long price;

}
