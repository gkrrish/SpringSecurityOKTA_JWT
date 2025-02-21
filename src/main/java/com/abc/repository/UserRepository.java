package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}