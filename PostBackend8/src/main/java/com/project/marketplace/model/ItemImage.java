package com.project.marketplace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "item_image")
public class ItemImage {
    @Id
    private String url;
    @ManyToOne
    @JoinColumn(name = "item_id") // This assumes your foreign key column in 'item_image' table is named 'item_id'
    private Item item;

    public ItemImage() {}

    public ItemImage(String url, Item item){
        this.url = url;
        this.item = item;
    }

    public String getUrl() {
        return url;
    }

    public ItemImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public ItemImage setItem(Item item) {
        this.item = item;
        return this;
    }
}


