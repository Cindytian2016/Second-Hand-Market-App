package com.example.markets.Item;

import com.example.markets.Entity.ItemEntity;
import com.example.markets.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Long id, String name, String description, Double price){
        itemRepository.save(new ItemEntity(id,name,description,price));

    }

    public List<ItemEntity> findAllItems() {
        return itemRepository.findAll();
    }
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
    public void deleteItemByName(String name) {
        itemRepository.deleteByName(name);
    }
}
