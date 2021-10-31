package com.b1a9idps.hibernatesandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b1a9idps.hibernatesandbox.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
