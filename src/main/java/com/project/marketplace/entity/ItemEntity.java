package com.project.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.marketplace.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ItemEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        Long id,
        @JsonProperty("user_id")
        Long userId, // Obtained from the security context, not user input.
        @JsonProperty("local_date")
        LocalDate date, // Automatically set to the current date.
        @Enumerated(EnumType.STRING)
        Category category,
        @JsonProperty("title")
        @NotBlank(message = "Title is mandatory")
        @Size(max = 100, message = "Title must be less than 100 characters")
        String itemTitle, // User input
        @JsonProperty("description")
        @NotBlank(message = "Description is mandatory")
        @Size(max = 1000, message = "Description must be less than 1000 characters")
        String itemDescription, // User input
        @JsonProperty("image")
        String itemImage, // To be implemented.
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
        @Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "Price must have no more than two decimal places")
        Double price,
        @Size(min = 10, max = 10, message = "Phone must be 10 digits")
        @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
        String phone,
        @Email(message = "Email should be valid")
        String email
) {
    public ItemEntity(
            Category category,
            String itemTitle,
            String itemDescription,
            Double price,
            String phone,
            String email) {
        this(null, getUserId(), LocalDate.now(), category, itemTitle, itemDescription, null, price, phone, email);
        // Put validation in controller: Validate that either phone or email is provided
        if ((phone == null || phone.isBlank()) && (email == null || email.isBlank())) {
            throw new IllegalArgumentException("Either phone or email must be provided.");
        }

    }

    private static Long getUserId() {
        // Implement logic to obtain the user ID
        // from Spring Security authentication principal.
        return 1L; // Placeholder
    }
}
