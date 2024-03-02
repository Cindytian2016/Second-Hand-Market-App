package com.laioffer.secondhandmarketapp02292024_1.repository;

import com.laioffer.secondhandmarketapp02292024_1.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {


    UserEntity findByUsername(String username);


    boolean existsByUsername(String username);
}
