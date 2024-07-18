package com.italianrestaurant.Menu.controller;

import com.italianrestaurant.Menu.constants.MenuItemConstants;
import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.dto.ResponseDto;
import com.italianrestaurant.Menu.service.IMenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
