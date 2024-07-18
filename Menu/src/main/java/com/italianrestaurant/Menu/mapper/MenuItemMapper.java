package com.italianrestaurant.Menu.mapper;

import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.entity.MenuItem;

public class MenuItemMapper {

    public static MenuItem mapToMenuItem(MenuItemDto menuItemDto, MenuItem menuItem){
        menuItem.setName(menuItemDto.getName());
        menuItem.setDescription(menuItemDto.getDescription());
        menuItem.setImageUrl(menuItemDto.getImageUrl());
        menuItem.setCategoryId(menuItemDto.getCategoryId());
        menuItem.setSubcategoryId(menuItem.getSubcategoryId());
        return menuItem;
    }
}
