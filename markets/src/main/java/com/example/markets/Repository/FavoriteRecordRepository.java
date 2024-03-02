package com.example.markets.Repository;

import com.example.markets.Entity.FavoriteRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

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