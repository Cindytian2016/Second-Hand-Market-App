package com.project.marketplace.controller;

import com.project.marketplace.entity.ItemEntity;
import com.project.marketplace.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@Validated
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemEntity> createProduct(@Valid @RequestBody ItemEntity item) {
        // Simulate getting the userId from a logged-in user's session or token
        // item.setUserId(getAuthenticatedUserId());
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    // Mock method to simulate user authentication and getting the userId
    private Long getAuthenticatedUserId() {
        // Assume this returns the logged-in user's ID
        return 1L;
    }
}

