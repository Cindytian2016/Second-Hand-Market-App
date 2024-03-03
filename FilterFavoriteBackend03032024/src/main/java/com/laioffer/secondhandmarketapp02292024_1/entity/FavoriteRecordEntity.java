/*
package com.laioffer.secondhandmarketapp02292024_1.entity;


import com.laioffer.secondhandmarketapp02292024_1.model.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "favorite_records")
public class FavoriteRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private ItemEntity item;

    @Column(name = "created_time")
    private LocalDateTime addedAt = LocalDateTime.now();

    // Constructors, getters, and setters
    public FavoriteRecordEntity(){

    }

    public FavoriteRecordEntity(Long id, UserEntity user, ItemEntity item, LocalDateTime addedAt) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.addedAt = addedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteRecordEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getItem(), that.getItem()) && Objects.equals(getAddedAt(), that.getAddedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getItem(), getAddedAt());
    }

}
*/

package com.laioffer.secondhandmarketapp02292024_1.entity;

import com.laioffer.secondhandmarketapp02292024_1.model.UserEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "favorite_records")
public class FavoriteRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Ensure 'id' matches the ID field name in UserEntity
    private UserEntity user;

    @Column(name = "created_at")
    private LocalDateTime addedAt;

    // Default constructor
    public FavoriteRecordEntity() {
        this.addedAt = LocalDateTime.now(); // Automatically set added time
    }

    // Custom constructor for initializing fields
    public FavoriteRecordEntity(UserEntity user, ProductEntity product) {
        this.user = user;
        this.product = product;
        this.addedAt = LocalDateTime.now(); // Automatically set added time
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteRecordEntity)) return false;
        FavoriteRecordEntity that = (FavoriteRecordEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(product, that.product) &&
                Objects.equals(addedAt, that.addedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, product, addedAt);
    }
}