package com.laioffer.secondhandmarket.model;


public record RegisterRequest(
        String username,
        String password,
        UserRole role
) {
}

