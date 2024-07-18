package com.italianrestaurant.Menu.controller;

import com.italianrestaurant.Menu.constants.MenuItemConstants;
import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.dto.ResponseDto;
import com.italianrestaurant.Menu.service.IMenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class MenuItemController {

    private IMenuItemService iMenuItemService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createMenuItem(@RequestBody MenuItemDto menuItemDto){
        iMenuItemService.createMenuItem(menuItemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MenuItemConstants.STATUS_201, MenuItemConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<MenuItemDto> fetchMenuItem(@RequestParam Long id){
        MenuItemDto menuItemDto = iMenuItemService.fetchMenuItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemDto);
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<MenuItemDto>> fetchMenuItems(){
        List<MenuItemDto> menuItemDtos = iMenuItemService.fetchMenuItems();
        return ResponseEntity.status(HttpStatus.OK).body(menuItemDtos);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateMenuItem(@RequestBody MenuItemDto menuItemDto, @RequestParam Long id) {
        iMenuItemService.updateMenuItem(menuItemDto, id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(MenuItemConstants.STATUS_200, MenuItemConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteMenuItem(@RequestParam Long id) {
        iMenuItemService.deleteMenuItem(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(MenuItemConstants.STATUS_200, MenuItemConstants.MESSAGE_200));
    }


}
