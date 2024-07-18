package com.italianrestaurant.Menu.dto;

import lombok.Data;

@Data
public class MenuItemDto {

    private String name;

    private String description;

    private String imageUrl;

    private Long categoryId;

    private Long subcategoryId;

    private Long price;

}
