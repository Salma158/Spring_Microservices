package com.italianrestaurant.Menu.mapper;

import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.entity.MenuItem;

public class MenuItemMapper {

    public static MenuItem mapToMenuItem(MenuItemDto menuItemDto, MenuItem menuItem){
        menuItem.setName(menuItemDto.getName());
        menuItem.setDescription(menuItemDto.getDescription());
        menuItem.setImageUrl(menuItemDto.getImageUrl());
        menuItem.setCategoryId(menuItemDto.getCategoryId());
        menuItem.setSubcategoryId(menuItemDto.getSubcategoryId());
        return menuItem;
    }

    public static MenuItemDto mapToMenuItemDto(MenuItem menuItem, MenuItemDto menuItemDto){
        menuItemDto.setName(menuItem.getName());
        menuItemDto.setDescription(menuItem.getDescription());
        menuItemDto.setImageUrl(menuItem.getImageUrl());
        menuItemDto.setCategoryId(menuItem.getCategoryId());
        menuItemDto.setSubcategoryId(menuItem.getSubcategoryId());
        return menuItemDto;
    }
}
