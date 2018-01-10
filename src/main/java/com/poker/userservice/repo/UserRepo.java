package com.poker.userservice.repo;

import com.poker.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
