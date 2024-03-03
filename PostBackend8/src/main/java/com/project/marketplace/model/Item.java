package com.project.marketplace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "item")
@JsonDeserialize(builder = Item.Builder.class)
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @ManyToOne
    @JsonProperty("user_id")
    private Long userId; // FIXME: Consider to use Seller; @ManyToOne type should not be Long
    @JsonProperty("local_date")
    private LocalDate date; // Automatically set to the current date.
    @Enumerated(EnumType.STRING)
    @JsonProperty("category")
    private Category category;
    @JsonProperty("title")
    private String itemTitle;
    @JsonProperty("description")
    private String itemDescription;
    @JsonProperty("address")
    private String address;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonProperty("images")
    private List<ItemImage> images;

    public Item() {}
    private Item(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.category = builder.category;
        this.itemTitle = builder.itemTitle;
        this.itemDescription = builder.itemDescription;
        this.address = builder.address;
        this.price = builder.price;
        this.phone = builder.phone;
        this.email = builder.email;
        this.images = builder.images;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getAddress() {
        return address;
    }

    public List<ItemImage> getImages() {
        return images;
    }

    public Item setImages(List<ItemImage> images){
        this.images = images;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public static class Builder {
        private Long id;
        private Long userId;
        private LocalDate date = LocalDate.now();
        private Category category;
        private String itemTitle;
        private String itemDescription;
        private String address;
        private Double price;
        private String phone;
        private String email;
        private List<ItemImage> images;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }
        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setItemTitle(String itemTitle) {
            this.itemTitle = itemTitle;
            return this;
        }

        public Builder setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Item build() {
            return new Item(this);
        }

        public Builder setImages(List<ItemImage> images) {
            this.images = images;
            return this;
        }
    }
}
