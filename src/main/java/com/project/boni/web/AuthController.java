package com.project.boni.web;

import com.project.boni.model.dto.ChangePasswordDto;
import com.project.boni.model.dto.JwtResponseDto;
import com.project.boni.model.dto.LoginDto;
import com.project.boni.model.dto.RegisterDto;
import com.project.boni.service.ShoppingCartService;
import com.project.boni.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HttpStatus registerUser(@RequestBody RegisterDto registerDto){
        this.userService.signUpUser(registerDto);
        return HttpStatus.OK;
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponseDto> loginUser(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok()
                .body(this.userService.signInUser(loginDto));
    }

    @PatchMapping("/user/changePassword")
    public HttpStatus changePasswordForUser(@RequestBody ChangePasswordDto changePasswordDto){
        this.userService.changePasswordForUser(changePasswordDto);
        return HttpStatus.OK;
    }
}
