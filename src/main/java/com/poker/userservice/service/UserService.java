package com.poker.userservice.service;

import com.poker.userservice.repo.UserRepo;
import com.poker.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(Integer id) {
        return userRepo.findOne(id);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateGame(User user) {
        return addUser(user);
    }
}
