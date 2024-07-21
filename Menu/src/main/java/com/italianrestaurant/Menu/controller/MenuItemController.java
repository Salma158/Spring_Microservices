package com.italianrestaurant.Menu.controller;

import com.italianrestaurant.Menu.constants.MenuItemConstants;
import com.italianrestaurant.Menu.dto.ErrorResponseDto;
import com.italianrestaurant.Menu.dto.MenuItemDto;
import com.italianrestaurant.Menu.dto.ResponseDto;
import com.italianrestaurant.Menu.service.IMenuItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for menu item in the Restaurant",
        description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE menu items details"
)
@RestController
@RequestMapping(value = "/api/menu-items", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class MenuItemController {

    private IMenuItemService iMenuItemService;

    @Operation(
            summary = "Create Menu Item REST API",
            description = "REST API to create new menu items"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping
    public ResponseEntity<ResponseDto> createMenuItem(@RequestBody @Valid MenuItemDto menuItemDto){
        iMenuItemService.createMenuItem(menuItemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MenuItemConstants.STATUS_201, MenuItemConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Menu Item Details REST API",
            description = "REST API to fetch Menu Item details based on the Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDto> fetchMenuItem(@RequestParam Long id){
        MenuItemDto menuItemDto = iMenuItemService.fetchMenuItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemDto);
    }

    @Operation(
            summary = "Fetch Menu Items Details REST API",
            description = "REST API to fetch All Menu Items details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping
    public ResponseEntity<List<MenuItemDto>> fetchMenuItems(){
        List<MenuItemDto> menuItemDtos = iMenuItemService.fetchMenuItems();
        return ResponseEntity.status(HttpStatus.OK).body(menuItemDtos);
    }

    @Operation(
            summary = "Update Menu Item Details REST API",
            description = "REST API to update Menu Item based on the Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateMenuItem(@RequestBody MenuItemDto menuItemDto, @RequestParam Long id) {
        iMenuItemService.updateMenuItem(menuItemDto, id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(MenuItemConstants.STATUS_200, MenuItemConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Delete Menu Item REST API",
            description = "REST API to delete Menu Item based the Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteMenuItem(@RequestParam Long id) {
        iMenuItemService.deleteMenuItem(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(MenuItemConstants.STATUS_200, MenuItemConstants.MESSAGE_200));
    }


}
