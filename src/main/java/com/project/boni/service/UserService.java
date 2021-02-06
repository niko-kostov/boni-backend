package com.project.boni.service;

import com.project.boni.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByEmail(String email);

    User save(User user);
}
