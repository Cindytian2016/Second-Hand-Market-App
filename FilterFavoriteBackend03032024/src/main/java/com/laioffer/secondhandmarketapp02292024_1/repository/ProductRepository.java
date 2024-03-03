/*
package com.laioffer.secondhandmarketapp02292024_1.repository;


import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Find products by category
    // Use a custom query to ignore case
    List<ProductEntity> findByCategory(String category);

    // Find products where price is less than a certain value
    List<ProductEntity> findByPriceLessThan(BigDecimal maxPrice);

    // Find products where price is greater than a certain value
    List<ProductEntity> findByPriceGreaterThan(BigDecimal minPrice);

    // Find products by price range
    List<ProductEntity> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Find products by category and within a price range
    List<ProductEntity> findByCategoryAndPriceBetween(String category, BigDecimal minPrice, BigDecimal maxPrice);

    Collection<Object> findAllBySellerId(Long sellerId);
}
*/

package com.laioffer.secondhandmarketapp02292024_1.repository;

import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Find products by category with case-insensitive search
    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.category) = LOWER(?1)")
    List<ProductEntity> findByCategoryIgnoreCase(String category);

    // Find products where price is less than a certain value
    List<ProductEntity> findByPriceLessThan(BigDecimal maxPrice);

    // Find products where price is greater than a certain value
    List<ProductEntity> findByPriceGreaterThan(BigDecimal minPrice);

    // Find products by price range
    List<ProductEntity> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Find products by category and within a price range with case-insensitive search
    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.category) = LOWER(?1) AND p.price BETWEEN ?2 AND ?3")
    List<ProductEntity> findByCategoryIgnoreCaseAndPriceBetween(String category, BigDecimal minPrice, BigDecimal maxPrice);
}
