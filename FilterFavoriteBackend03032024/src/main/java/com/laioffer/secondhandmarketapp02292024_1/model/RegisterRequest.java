package com.laioffer.secondhandmarketapp02292024_1.model;


public record RegisterRequest(
        String username,
        String password,
        UserRole role
) {
}
