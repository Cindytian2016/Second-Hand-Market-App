package com.project.marketplace.service;

import com.project.marketplace.repository.ItemRepository;
import com.project.marketplace.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public ItemEntity saveItem(ItemEntity item) {
        return repository.save(item);
    }
}
