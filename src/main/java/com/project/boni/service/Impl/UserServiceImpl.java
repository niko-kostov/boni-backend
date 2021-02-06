package com.project.boni.service.Impl;

import com.project.boni.model.User;
import com.project.boni.model.exceptions.UserNotFoundException;
import com.project.boni.repository.UserRepository;
import com.project.boni.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findById(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
