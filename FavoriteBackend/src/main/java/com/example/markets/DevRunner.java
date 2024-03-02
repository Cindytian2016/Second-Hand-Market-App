package com.example.markets;

import com.example.markets.Entity.ItemEntity;
import com.example.markets.Entity.UserEntity;
import com.example.markets.Repository.FavoriteRecordRepository;
import com.example.markets.Repository.ItemRepository;
import com.example.markets.Repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DevRunner implements ApplicationRunner {
    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    private final FavoriteRecordRepository favoriteRecordRepository;
    public DevRunner(
            UserRepository userRepository,
            ItemRepository itemRepository,
            FavoriteRecordRepository favoriteRecordRepository
    ){
        this.favoriteRecordRepository=favoriteRecordRepository;
        this.userRepository=userRepository;
        this.itemRepository=itemRepository;

    }

    @Override
    public void run(ApplicationArguments args){
        loadItemData();
    }

    private void loadItemData() {
        // Example items
        System.out.println("Sample items loaded");
        itemRepository.saveAll(List.of(
            new ItemEntity(null,"Laptop", "High-performance laptop", 1200.00),
            new ItemEntity(null,"Smartphone", "Latest model smartphone", 800.00),
            new ItemEntity(null,"Headphones", "Noise-cancelling headphones", 150.00)
        ));

        UserEntity user = new UserEntity(null, "admin", "admin");
        userRepository.save(user);
    }
}
