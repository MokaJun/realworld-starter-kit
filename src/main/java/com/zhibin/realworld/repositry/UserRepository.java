package com.zhibin.realworld.repositry;

import com.zhibin.realworld.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    Optional<User> findUserByEmail(String email);

}
