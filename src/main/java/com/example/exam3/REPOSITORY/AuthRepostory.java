package com.example.exam3.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepostory extends JpaRepository<User, Integer> {

User findById(int id);
}
