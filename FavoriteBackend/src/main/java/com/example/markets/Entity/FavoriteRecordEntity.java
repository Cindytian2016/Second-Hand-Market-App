package com.example.markets.Entity;

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
