/**
package com.laioffer.secondhandmarketapp02292024_1.Favorite;

import com.laioffer.secondhandmarketapp02292024_1.entity.FavoriteRecordEntity;
import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import com.laioffer.secondhandmarketapp02292024_1.model.UserEntity;
import com.laioffer.secondhandmarketapp02292024_1.model.UserEntity;
import com.laioffer.secondhandmarketapp02292024_1.repository.FavoriteRecordRepository;
import com.laioffer.secondhandmarketapp02292024_1.repository.ProductRepository;
import com.laioffer.secondhandmarketapp02292024_1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FavoriteService {
    private final FavoriteRecordRepository favoriteRecordRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public FavoriteService(FavoriteRecordRepository favoriteRecordRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.favoriteRecordRepository = favoriteRecordRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public FavoriteRecordEntity addFavorite(Long userId, Long itemId) {
        if (favoriteRecordRepository.existsByUserIdAndItemId(userId, itemId)) {
            throw new IllegalStateException("Favorite already exists for user " + userId + " and item " + itemId);
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        ProductEntity item = productRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + itemId));

        FavoriteRecordEntity favorite = new FavoriteRecordEntity();
        favorite.setUser(user);
        favorite.setProduct(product);
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
 */

package com.laioffer.secondhandmarketapp02292024_1.Favorite;

import com.laioffer.secondhandmarketapp02292024_1.entity.FavoriteRecordEntity;
import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import com.laioffer.secondhandmarketapp02292024_1.model.UserEntity;
import com.laioffer.secondhandmarketapp02292024_1.repository.FavoriteRecordRepository;
import com.laioffer.secondhandmarketapp02292024_1.repository.ProductRepository;
import com.laioffer.secondhandmarketapp02292024_1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoriteService {
    private final FavoriteRecordRepository favoriteRecordRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public FavoriteService(FavoriteRecordRepository favoriteRecordRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.favoriteRecordRepository = favoriteRecordRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public FavoriteRecordEntity addFavorite(Long userId, Long productId) { // Changed itemId to productId
        if (favoriteRecordRepository.existsByUserIdAndProductIdCustom(userId, productId)) { // Changed method call to reflect productId
            throw new IllegalStateException("Favorite already exists for user " + userId + " and product " + productId);
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        ProductEntity product = productRepository.findById(productId) // Changed variable name to product
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        FavoriteRecordEntity favorite = new FavoriteRecordEntity();
        favorite.setUser(user);
        favorite.setProduct(product); // Changed setItem to setProduct
        return favoriteRecordRepository.save(favorite);
    }

    public boolean existsFavorite(Long userId, Long productId) { // Changed itemId to productId
        return favoriteRecordRepository.existsByUserIdAndProductIdCustom(userId, productId); // Changed method call to reflect productId
    }

    public List<FavoriteRecordEntity> findFavoritesByUserId(Long userId) {
        return favoriteRecordRepository.findAllByUserId(userId);
    }

    @Transactional
    public void removeFavorite(Long userId, Long productId) { // Changed itemId to productId
        if (!favoriteRecordRepository.existsByUserIdAndProductIdCustom(userId, productId)) { // Changed method call to reflect productId
            throw new IllegalStateException("Favorite does not exist for user " + userId + " and product " + productId);
        }
        favoriteRecordRepository.deleteByUserIdAndProductId(userId, productId); // Changed method call to reflect productId
    }
}

