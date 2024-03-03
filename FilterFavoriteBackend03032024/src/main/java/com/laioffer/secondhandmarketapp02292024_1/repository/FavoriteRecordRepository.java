/**
package com.laioffer.secondhandmarketapp02292024_1.repository;

import com.laioffer.secondhandmarketapp02292024_1.Entity.FavoriteRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRecordRepository extends JpaRepository<FavoriteRecordEntity, Long> {

    List<FavoriteRecordEntity> findAllByUserId(Long userId);

    List<FavoriteRecordEntity> findAllByItemId(Long itemId);

    boolean existsByUserIdAndItemId(Long userId, Long itemId);

    @Query(value="SELECT * FROM favorite_records f WHERE f.user_id = :userId",nativeQuery = true)
    List<FavoriteRecordEntity> findFavoriteItemIdsByUserId(Long userId);

    @Query(value="SELECT * FROM favorite_records f WHERE f.user_id = :userId AND f.item_id = :itemId",nativeQuery = true)
    FavoriteRecordEntity findByUserIdAndItemId(@Param("userId") Long userId, @Param("itemId") Long itemId);

    @Modifying
    @Query(value="DELETE FROM favorite_records f WHERE f.user_id = :userId AND f.item_id = :itemId",nativeQuery = true)
    void deleteByUserIdAndItemId(@Param("userId")Long userId, @Param("itemId")Long itemId);
}
*/


package com.laioffer.secondhandmarketapp02292024_1.repository;

import com.laioffer.secondhandmarketapp02292024_1.entity.FavoriteRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FavoriteRecordRepository extends JpaRepository<FavoriteRecordEntity, Long> {
    List<FavoriteRecordEntity> findAllByUserId(Long userId);
    @Query("SELECT f FROM FavoriteRecordEntity f WHERE f.product.productId = :productId")
    List<FavoriteRecordEntity> findAllByProductId(@Param("productId") Long productId);

    //boolean existsByUserIdAndProductId(Long userId, Long productId);
    @Query("SELECT COUNT(f) > 0 FROM FavoriteRecordEntity f WHERE f.user.id = :userId AND f.product.productId = :productId")
    boolean existsByUserIdAndProductIdCustom(@Param("userId") Long userId, @Param("productId") Long productId);

    @Query(value="SELECT * FROM favorite_records f WHERE f.user_id = :userId", nativeQuery = true)
    List<FavoriteRecordEntity> findFavoriteProductIdsByUserId(@Param("userId") Long userId);

    @Query(value="SELECT * FROM favorite_records f WHERE f.user_id = :userId AND f.product_id = :productId", nativeQuery = true)
    FavoriteRecordEntity findByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

    @Modifying
    @Query(value="DELETE FROM favorite_records f WHERE f.user_id = :userId AND f.product_id = :productId", nativeQuery = true)
    void deleteByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);
}

