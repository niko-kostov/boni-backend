package com.project.boni.service;

import com.project.boni.model.User;
import com.project.boni.model.dto.JwtResponseDto;
import com.project.boni.model.dto.LoginDto;
import com.project.boni.model.dto.RegisterDto;

import java.util.List;

public interface UserService {

    List<User> findAll();

    JwtResponseDto signInUser(LoginDto loginDto);

    void signUpUser(RegisterDto registerDto);
}
