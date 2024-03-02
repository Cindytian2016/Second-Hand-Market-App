
package com.laioffer.secondhandmarket.model;

public record UserDto(
        Long user_id,
        String username,
        UserRole role
) {
    public UserDto(UserEntity entity) {
        this(
                entity.getId(),
                entity.getUsername(),
                entity.getRole()
        );
    }
}

