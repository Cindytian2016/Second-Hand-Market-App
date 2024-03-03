/**
package com.laioffer.secondhandmarketapp02292024_1.Favorite;

import com.laioffer.secondhandmarketapp02292024_1.Favorite.FavoriteService;
import com.laioffer.secondhandmarketapp02292024_1.entity.FavoriteRecordEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService){
        this.favoriteService=favoriteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavorite(@RequestParam Long userId, @RequestParam Long itemId) {
        favoriteService.addFavorite(userId, itemId);
    }

    @DeleteMapping("/{userId}/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFavorite(@PathVariable Long userId, @PathVariable Long itemId) {
        favoriteService.removeFavorite(userId, itemId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FavoriteRecordEntity>> listUserFavorites(@PathVariable Long userId) {
        List<FavoriteRecordEntity> favoriteItems = favoriteService.findFavoritesByUserId(userId);
        return ResponseEntity.ok(favoriteItems);
    }

    // Check if an item is favorited by a user
    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsFavorite(@RequestParam Long userId, @RequestParam Long itemId) {
        boolean exists = favoriteService.existsFavorite(userId, productId);
        return ResponseEntity.ok(exists);
    }
}
*/

package com.laioffer.secondhandmarketapp02292024_1.Favorite;

import com.laioffer.secondhandmarketapp02292024_1.entity.FavoriteRecordEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavorite(@RequestParam Long userId, @RequestParam Long productId) {
        favoriteService.addFavorite(userId, productId);
    }

    @DeleteMapping("/{userId}/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFavorite(@PathVariable Long userId, @PathVariable Long productId) {
        favoriteService.removeFavorite(userId, productId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FavoriteRecordEntity>> listUserFavorites(@PathVariable Long userId) {
        List<FavoriteRecordEntity> favoriteItems = favoriteService.findFavoritesByUserId(userId);
        return ResponseEntity.ok(favoriteItems);
    }

    // Check if an item is favorited by a user
    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsFavorite(@RequestParam Long userId, @RequestParam Long productId) {
        boolean exists = favoriteService.existsFavorite(userId, productId);
        return ResponseEntity.ok(exists);
    }
}
