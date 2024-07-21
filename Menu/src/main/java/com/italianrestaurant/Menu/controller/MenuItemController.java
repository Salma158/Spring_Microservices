package com.italianrestaurant.Menu.controller;

import com.italianrestaurant.Menu.constants.MenuItemConstants;
import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.dto.ResponseDto;
import com.italianrestaurant.Menu.service.IMenuItemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/menu-items", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class MenuItemController {

    private IMenuItemService iMenuItemService;

    @PostMapping
    public ResponseEntity<ResponseDto> createMenuItem(@RequestBody @Valid MenuItemDto menuItemDto){
        iMenuItemService.createMenuItem(menuItemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MenuItemConstants.STATUS_201, MenuItemConstants.MESSAGE_201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDto> fetchMenuItem(@RequestParam Long id){
        MenuItemDto menuItemDto = iMenuItemService.fetchMenuItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemDto);
    }

    @GetMapping
    public ResponseEntity<List<MenuItemDto>> fetchMenuItems(){
        List<MenuItemDto> menuItemDtos = iMenuItemService.fetchMenuItems();
        return ResponseEntity.status(HttpStatus.OK).body(menuItemDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateMenuItem(@RequestBody MenuItemDto menuItemDto, @RequestParam Long id) {
        iMenuItemService.updateMenuItem(menuItemDto, id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(MenuItemConstants.STATUS_200, MenuItemConstants.MESSAGE_200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteMenuItem(@RequestParam Long id) {
        iMenuItemService.deleteMenuItem(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(MenuItemConstants.STATUS_200, MenuItemConstants.MESSAGE_200));
    }


}
