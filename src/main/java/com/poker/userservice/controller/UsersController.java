package com.poker.userservice.controller;

import com.poker.userservice.model.User;
import com.poker.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getGame(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addGame(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User updateGame(@RequestBody User user) {
        return userService.updateGame(user);
    }

}
