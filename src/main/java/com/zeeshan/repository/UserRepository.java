package com.zeeshan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeeshan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
