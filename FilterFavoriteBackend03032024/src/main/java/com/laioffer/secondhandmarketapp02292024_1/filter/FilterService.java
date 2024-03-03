/**
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
*/

package com.laioffer.secondhandmarketapp02292024_1.filter;

import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import com.laioffer.secondhandmarketapp02292024_1.model.ProductDto;
import com.laioffer.secondhandmarketapp02292024_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductDto> filterProducts(String category, BigDecimal minPrice, BigDecimal maxPrice) {
        List<ProductEntity> products;
        if (category != null && minPrice != null && maxPrice != null) {
            products = productRepository.findByCategoryIgnoreCaseAndPriceBetween(category, minPrice, maxPrice);
        } else if (category != null) {
            products = productRepository.findByCategoryIgnoreCase(category);
        } else {
            products = productRepository.findAll();
        }
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Helper method to convert ProductEntity to ProductDto
    private ProductDto convertToDto(ProductEntity product) {
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getImages(),
                product.getCreatedAt(),
                product.getSellerId());
    }
}

