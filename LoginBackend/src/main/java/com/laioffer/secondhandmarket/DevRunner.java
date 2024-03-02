package com.laioffer.secondhandmarket;


import com.laioffer.secondhandmarket.model.ProductsEntity;
import com.laioffer.secondhandmarket.model.UserEntity;
import com.laioffer.secondhandmarket.model.UserRole;
import com.laioffer.secondhandmarket.repository.ProductRepository;
import com.laioffer.secondhandmarket.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component
public class DevRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(DevRunner.class);

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DevRunner(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        generateSampleData();

        // Example of logging the created data
        List<UserEntity> users = userRepository.findAll();
        logger.info("Created Users: " + users);

        List<ProductsEntity> products = productRepository.findAll();
        logger.info("Created Products: " + products);
    }

    private void generateSampleData() {
        // Create and save users
        userRepository.saveAll(List.of(
                new UserEntity(null, "user1", "password1", "user1@example.com", UserRole.Seller),
                new UserEntity(null, "user2", "password2", "user2@example.com", UserRole.Seller),
                new UserEntity(null, "user3", "password3", "user3@example.com", UserRole.Buyer)
        ));

        // Create and save products
        productRepository.saveAll(List.of(
                new ProductsEntity(null, "Laptop", "High-end gaming laptop", 1200.00, "Electronics", "image1.jpg", null), // Assuming null for the user who posted this product, replace as necessary
                new ProductsEntity(null, "Smartphone", "Latest model smartphone", 999.99, "Electronics", "image2.jpg", null), // Replace null as necessary
                new ProductsEntity(null, "Coffee Maker", "Automatic coffee maker", 49.99, "Home Appliances", "image3.jpg", null) // Replace null as necessary
        ));
    }
}
