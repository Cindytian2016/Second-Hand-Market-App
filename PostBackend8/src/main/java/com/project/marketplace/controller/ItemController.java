package com.project.marketplace.controller;

import com.project.marketplace.model.Category;
import com.project.marketplace.model.Item;
import com.project.marketplace.service.ItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("/add")
    public void addItem(
            @RequestParam("user_id") Long userId,
            @RequestParam("category") Category category,
            @RequestParam("title") String itemTitle,
            @RequestParam("description") String itemDescription,
            @RequestParam("address") String address,
            @RequestParam("price") Double price,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("images") MultipartFile[] images
    ){
        Item item = new Item.Builder()
                .setItemTitle(itemTitle)
                .setItemDescription(itemDescription)
                .setCategory(category)
                .setAddress(address)
                .setPrice(price)
                .setPhone(phone)
                .setEmail(email)
                .build();

        // .setHost(new User.Builder().setUsername(host).build()) FIXME: use role seller builder
        itemService.add(item, images);
    }
}

