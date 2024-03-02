package com.example.markets.Favorite;

import com.example.markets.Entity.FavoriteRecordEntity;
import com.example.markets.Entity.ItemEntity;
import com.example.markets.Entity.UserEntity;
import com.example.markets.Repository.FavoriteRecordRepository;
import com.example.markets.Repository.ItemRepository;
import com.example.markets.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FavoriteService {
    private final FavoriteRecordRepository favoriteRecordRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public FavoriteService(FavoriteRecordRepository favoriteRecordRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.favoriteRecordRepository = favoriteRecordRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public FavoriteRecordEntity addFavorite(Long userId, Long itemId) {
        if (favoriteRecordRepository.existsByUserIdAndItemId(userId, itemId)) {
            throw new IllegalStateException("Favorite already exists for user " + userId + " and item " + itemId);
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        ItemEntity item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + itemId));

        FavoriteRecordEntity favorite = new FavoriteRecordEntity();
        favorite.setUser(user);
        favorite.setItem(item);
        return favoriteRecordRepository.save(favorite);
    }

    public boolean existsFavorite(Long userId, Long itemId) {
        return favoriteRecordRepository.existsByUserIdAndItemId(userId, itemId);
    }

    public List<FavoriteRecordEntity> findFavoritesByUserId(Long userId) {
        List<FavoriteRecordEntity> itemIds = favoriteRecordRepository.findAllByUserId(userId);
        return itemIds;
    }

    @Transactional
    public void removeFavorite(Long userId, Long itemId) {
        if (!favoriteRecordRepository.existsByUserIdAndItemId(userId, itemId)) {
            throw new IllegalStateException("Favorite does not exist for user " + userId + " and item " + itemId);
        }
        favoriteRecordRepository.deleteByUserIdAndItemId(userId, itemId);
    }





}
