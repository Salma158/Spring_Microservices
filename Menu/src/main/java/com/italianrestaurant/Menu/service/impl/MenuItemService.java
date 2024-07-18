package com.italianrestaurant.Menu.service.impl;

import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.entity.MenuItem;
import com.italianrestaurant.Menu.exception.ResourceNotFoundException;
import com.italianrestaurant.Menu.mapper.MenuItemMapper;
import com.italianrestaurant.Menu.repository.MenuItemRepository;
import com.italianrestaurant.Menu.service.IMenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        MenuItem menuItem= menuItemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Menu Item", "Id", id));
        MenuItemDto menuItemDto = MenuItemMapper.mapToMenuItemDto(menuItem, new MenuItemDto());
        return menuItemDto;
    }

    @Override
    public List<MenuItemDto> fetchMenuItems() {
        List<MenuItem> MenuItems = menuItemRepository.findAll();
        return MenuItems.stream()
                .map((menuItem) -> MenuItemMapper.mapToMenuItemDto(menuItem, new MenuItemDto()))
                .collect(Collectors.toList());

    }

    @Override
    public void updateMenuItem(MenuItemDto menuItemDto, Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item", "Id", id));
        MenuItemMapper.mapToMenuItem(menuItemDto, menuItem);
        menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteMenuItem(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item", "Id", id));
        menuItemRepository.deleteById(id);
    }
}
