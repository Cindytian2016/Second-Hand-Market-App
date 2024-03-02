package com.example.markets.Repository;
import com.example.markets.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Uncommented and corrected method name
    UserEntity findByUsername(String username);

    boolean existsByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE username = :username", nativeQuery = true)
    void deleteByUsername(String username);
}