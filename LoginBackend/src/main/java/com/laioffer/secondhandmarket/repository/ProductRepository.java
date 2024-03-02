package com.laioffer.secondhandmarket.repository;


import com.laioffer.secondhandmarket.model.ProductsEntity;
import com.laioffer.secondhandmarket.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {
    // example
    // Find products by category
    List<ProductsEntity> findByCategory(String category);

    // Find products by seller
    List<ProductsEntity> findBySeller(UserEntity seller);

    // Find products within a certain price range
    List<ProductsEntity> findByPriceBetween(Double minPrice, Double maxPrice);

    // Find products with a name containing a specific string (search functionality)
    List<ProductsEntity> findByNameContainingIgnoreCase(String name);
}
