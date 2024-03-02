package com.laioffer.secondhandmarketapp02292024_1.filter;

import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import com.laioffer.secondhandmarketapp02292024_1.model.ProductDto;
import com.laioffer.secondhandmarketapp02292024_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterService {

    private final ProductRepository productRepository;

    @Autowired
    public FilterService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> filterProducts(String category, BigDecimal minPrice, BigDecimal maxPrice) {
        List<ProductEntity> products = productRepository.findByCategoryAndPriceBetween(category, minPrice, maxPrice);
        return products.stream().map(product -> new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getImages(),
                product.getCreatedAt(),
                product.getSellerId())
        ).collect(Collectors.toList());

    }
}
