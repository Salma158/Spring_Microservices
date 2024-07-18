package com.italianrestaurant.Menu.service;

import com.italianrestaurant.Menu.dto.MenuItemDto;

import java.util.List;

public interface IMenuItemService {
    void createMenuItem(MenuItemDto menuItemDto);
    MenuItemDto fetchMenuItem(Long id);
    List<MenuItemDto> fetchMenuItems();
    void updateMenuItem(MenuItemDto menuItemDto, Long id);
    void deleteMenuItem(Long id);
}
