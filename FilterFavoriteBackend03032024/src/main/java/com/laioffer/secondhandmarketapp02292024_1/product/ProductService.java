/**package com.laioffer.secondhandmarketapp02292024_1.product;

import com.laioffer.secondhandmarketapp02292024_1.entity.ProductEntity;
import com.laioffer.secondhandmarketapp02292024_1.model.ProductDto;
import com.laioffer.secondhandmarketapp02292024_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private final ApplicationContext context;

    @Autowired
    public ProductService(ApplicationContext context) {
        this.context = context;
        this.productRepository = context.getBean(ProductRepository.class);
    }

    // Diagnostic method to check bean presence
    public void checkBean() {
        boolean hasBean = context.containsBean("productRepository");
        System.out.println("Does context contain productRepository? " + hasBean);
    }


    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        // Ensure repository is not null
        if (this.productRepository == null) {
            // Attempt to fetch the bean again if null
            this.productRepository = context.getBean(ProductRepository.class);
        }
        return productRepository.findAll().stream()
                .map(product -> new ProductDto(
                        product.getProductId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getImages(),
                        product.getCreatedAt(),
                        product.getSellerId()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        ProductEntity product = new ProductEntity(
                productDto.getPrice(),
                productDto.getCreatedAt(),
                productDto.getSellerId(),
                productDto.getCategory(),
                productDto.getDescription(),
                productDto.getName(),
                productDto.getImages());
        ProductEntity savedProduct = productRepository.save(product);
        return new ProductDto(
                savedProduct.getProductId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getCategory(),
                savedProduct.getImages(),
                savedProduct.getCreatedAt(),
                savedProduct.getSellerId());
    }

    @Transactional(readOnly = true)
    public List<ProductDto> filterProducts(String category, BigDecimal minPrice, BigDecimal maxPrice) {
        List<ProductEntity> products;
        if (category != null && minPrice != null && maxPrice != null) {
            products = productRepository.findByCategoryAndPriceBetween(category, minPrice, maxPrice);
        } else if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            // Fallback to fetching all products or handle this scenario based on your needs
            products = productRepository.findAll();
        }
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

    @Transactional(readOnly = true)
    public List<ProductDto> getProductsByCategory(String category) {
        // Use the repository to find products by category
        List<ProductEntity> products = productRepository.findByCategory(category);

        // Map ProductEntity objects to ProductDto objects
        return products.stream()
                .map(product -> new ProductDto(
                        product.getProductId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getImages(),
                        product.getCreatedAt(),
                        product.getSellerId()))
                .collect(Collectors.toList());
    }
}
*/