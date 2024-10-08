package com.duvanlabrador.pizza.persistence.repository;

import com.duvanlabrador.pizza.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "SELECT * FROM users u WHERE u.username = ?1", nativeQuery = true)
    Optional<UserEntity> findByUsername(@Param("username") String username);
}
