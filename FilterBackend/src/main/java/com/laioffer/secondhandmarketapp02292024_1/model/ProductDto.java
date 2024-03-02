package com.laioffer.secondhandmarketapp02292024_1.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductDto {

    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private List<String> images; // Assuming images are stored as a list of strings (URLs)
    private LocalDate createdAt;
    private Long sellerId; // Corresponds to the user_id of the seller in the users table

    // Default constructor
    public ProductDto() {
    }

    // Constructor with all fields
    public ProductDto(Long productId, String name, String description, BigDecimal price, String category, List<String> images, LocalDate createdAt, Long sellerId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.images = images;
        this.createdAt = createdAt;
        this.sellerId = sellerId;
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    // Optionally, you can add toString, equals, and hashCode methods for debugging and comparison purposes
}
