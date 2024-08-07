package com.apoolla.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apoolla.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
