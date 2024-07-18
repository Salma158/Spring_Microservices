package com.italianrestaurant.Menu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MenuItemDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private String imageUrl;

    @NotNull(message = "CategoryId is required")
    private Long categoryId;

    @NotNull(message = "SubcategoryId is required")
    private Long subcategoryId;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Long price;

}
