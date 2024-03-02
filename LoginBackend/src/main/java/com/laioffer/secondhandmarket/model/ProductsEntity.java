package com.laioffer.secondhandmarket.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity // Hibernate annotation
@Table(name = "products") // Table name
public class ProductsEntity {
    @Id // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long product_id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String images; // Assuming multiple image links can be stored as a text field
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    // Constructors
    public ProductsEntity() {
    }

    public ProductsEntity(Long product_id, String name, String description, Double price, String category, String images, UserEntity seller) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.images = images;
        this.seller = seller;
    }

    // Getters and Setters
    public Long getId() {
        return product_id;
    }

    public void setId(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    // Override equals, hashCode, and toString methods to include all fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductsEntity)) return false;
        ProductsEntity that = (ProductsEntity) o;
        return Objects.equals(product_id, that.product_id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(category, that.category) && Objects.equals(images, that.images) && Objects.equals(seller, that.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, name, description, price, category, images, seller);
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", images='" + images + '\'' +
                ", createdAt=" + createdAt +
                ", seller=" + (seller != null ? seller.getId() : null) +
                '}';
    }
}
