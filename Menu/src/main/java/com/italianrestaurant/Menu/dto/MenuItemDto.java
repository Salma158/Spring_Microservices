package com.italianrestaurant.Menu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(
        name = "MenuItem",
        description = "Schema to hold Menu Item information"
)
public class MenuItemDto {

    @NotBlank(message = "Name is required")
    @Schema(
            description = "Name of Menu Item", example = "cacio e pepe"
    )
    private String name;

    @NotBlank(message = "Description is required")
    @Schema(
            description = "Description of Menu Item", example = "Cacio e pepe is a pasta dish typical of the Lazio region of Italy."
    )
    private String description;

    @Schema(
            description = "Image of the Menu Item"
    )
    private String imageUrl;

    @NotNull(message = "CategoryId is required")
    @Schema(
            description = "category of the Menu Item, like : main dishes", example = "1"
    )
    private Long categoryId;

    @NotNull(message = "SubcategoryId is required")
    @Schema(
            description = "sub category of the Menu Item, like : pasta", example = "5"
    )
    private Long subcategoryId;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Schema(
            description = "The price of the Menu Item", example = "300"
    )
    private Long price;

}
