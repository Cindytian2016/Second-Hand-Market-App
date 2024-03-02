package com.laioffer.secondhandmarketapp02292024_1.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity // This annotation marks this class as a JPA entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will handle the generation of product ID
    private Long productId;

    private BigDecimal price;
    private LocalDate createdAt;
    private Long sellerId;
    private String category;
    private String description;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY) // This annotation is used to specify a collection of instances of a basic type or embeddable class.
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id")) // This specifies the table that stores the images.
    @Column(name = "image") // This specifies the column name in the table where the images are stored.
    private List<String> images; // No change needed here

    // Default constructor required by JPA
    public ProductEntity() {
    }

    // Custom constructor to initialize fields
    public ProductEntity(BigDecimal price, LocalDate createdAt, Long sellerId, String category, String description, String name, List<String> images) {
        this.price = price;
        this.createdAt = createdAt;
        this.sellerId = sellerId;
        this.category = category;
        this.description = description;
        this.name = name;
        this.images = images;
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
}

