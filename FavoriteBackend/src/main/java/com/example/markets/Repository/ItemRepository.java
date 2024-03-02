package com.example.markets.Repository;

import com.example.markets.Entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

//    ItemEntity findByItemId(Long itemId);
//    ItemEntity findById(Long id);
    ItemEntity findByName(String name);
    @Modifying
    @Query(value = "DELETE FROM items i WHERE i.name = :name",nativeQuery = true)
    void deleteByName(String name);

}