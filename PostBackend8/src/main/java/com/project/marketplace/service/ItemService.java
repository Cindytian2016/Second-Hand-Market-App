package com.project.marketplace.service;

import com.project.marketplace.model.Item;
import com.project.marketplace.model.ItemImage;
import com.project.marketplace.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository repository;
    private final ImageStorageService imageStorageService;
    public ItemService(ItemRepository repository, ImageStorageService imageStorageService) {
        this.repository = repository;
        this.imageStorageService = imageStorageService;
    }

    public void add(Item item, MultipartFile[] images){
        List<ItemImage> stayImages = Arrays.stream(images)
                .filter(image -> !image.isEmpty())
                .parallel()
                .map(imageStorageService::save)
                .map(mediaLink -> new ItemImage(mediaLink, item))
                .collect(Collectors.toList());
        item.setImages(stayImages);
        repository.save(item);
    }
}
