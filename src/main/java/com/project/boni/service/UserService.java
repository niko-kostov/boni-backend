package com.project.boni.service;

import com.project.boni.model.User;
import com.project.boni.model.dto.*;

import java.util.List;

public interface UserService {

    User findById(String email);

    List<User> findAll();

    JwtResponseDto signInUser(LoginDto loginDto);

    void signUpUser(RegisterDto registerDto);

    void changePasswordForUser(ChangePasswordDto changePasswordDto);

    void changeProfileImage(ChangeProfileImageDto changeProfileImageDto);

    EditProfileResponseDto editProfileForUser(EditProfileDto editProfileDto);
}
