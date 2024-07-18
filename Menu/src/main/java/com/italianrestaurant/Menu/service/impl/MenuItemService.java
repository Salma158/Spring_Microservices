package com.italianrestaurant.Menu.service.impl;

import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.entity.MenuItem;
import com.italianrestaurant.Menu.mapper.MenuItemMapper;
import com.italianrestaurant.Menu.repository.MenuItemRepository;
import com.italianrestaurant.Menu.service.IMenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MenuItemService implements IMenuItemService {

    private MenuItemRepository menuItemRepository;
    @Override
    public void createMenuItem(MenuItemDto menuItemDto) {
        MenuItem menuItem = MenuItemMapper.mapToMenuItem(menuItemDto, new MenuItem());
        menuItem.setCreatedAt(LocalDateTime.now());
        menuItem.setCreatedBy("salma");
        menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItemDto fetchMenuItem(Long id) {
        return null;
    }
}
