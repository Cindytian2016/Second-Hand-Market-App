package com.example.markets.Item;

import com.example.markets.Entity.ItemEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

//    @PostMapping
//    public ResponseEntity<ItemEntity> addItem(@RequestBody ItemEntity item) {
//        ItemEntity newItem = itemService.saveItem(item);
//        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") double price
    ){
        itemService.createItem(id,name,description,price);
    }

    // Delete an item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }

    // Get all items
    @GetMapping
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        List<ItemEntity> items = itemService.findAllItems();
        return ResponseEntity.ok(items);
    }





}
