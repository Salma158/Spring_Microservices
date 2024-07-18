package com.italianrestaurant.Menu.service;

import com.italianrestaurant.Menu.dto.MenuItemDto;

public interface IMenuItemService {
    void createMenuItem(MenuItemDto menuItemDto);
    MenuItemDto fetchMenuItem(Long id);
}
