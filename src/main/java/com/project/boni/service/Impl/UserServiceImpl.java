package com.project.boni.service.Impl;

import com.project.boni.model.User;
import com.project.boni.model.dto.*;
import com.project.boni.model.enums.ERole;
import com.project.boni.model.exceptions.*;
import com.project.boni.repository.RoleRepository;
import com.project.boni.repository.UserRepository;
import com.project.boni.security.jwt.JwtUtils;
import com.project.boni.security.services.UserDetailsImpl;
import com.project.boni.service.ShoppingCartService;
import com.project.boni.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final ShoppingCartService shoppingCartService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils,
                           ShoppingCartService shoppingCartService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User findById(String email) {
        return this.userRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public JwtResponseDto signInUser(LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

        User user = this.findById(loginDto.getEmail());

        if (!user.isActive()) {
            throw new UserNotActiveException(user.getEmail());
        }

        if (user.isDeleted()) {
            throw new UserDeletedException(user.getEmail());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Long activeShoppingCartForUserId = this.shoppingCartService.getActiveShoppingCart(loginDto.getEmail()).getShoppingCartId();

        JwtResponseDto jwtResponseDto = new JwtResponseDto();
        jwtResponseDto.setAccessToken(jwt);
        jwtResponseDto.setEmail(userDetails.getUsername());
        jwtResponseDto.setActiveShoppingCartId(activeShoppingCartForUserId);
        jwtResponseDto.setFullName(user.getFirstname() + " " + user.getLastname());
        jwtResponseDto.setProfileImage(user.getProfileImage());
        jwtResponseDto.setPhoneNumber(user.getPhoneNumber());
        jwtResponseDto.setRoles(roles);

        return jwtResponseDto;
    }

    @Transactional
    @Override
    public void signUpUser(RegisterDto registerDto) {
        if (userRepository.findById(registerDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(registerDto.getEmail());
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setPhoneNumber(registerDto.getPhoneNumber());
        user.setFirstname(registerDto.getFirstName());
        user.setLastname(registerDto.getLastName());
        user.setProfileImage(registerDto.getProfileImage());
        user.setRole(roleRepository.findByName(ERole.ROLE_USER).get());
        user.setActive(true);
        user.setDeleted(false);

        userRepository.save(user);
    }

    @Override
    public void changePasswordForUser(ChangePasswordDto changePasswordDto) {
        User user = this.findById(changePasswordDto.getEmail());

        if (passwordEncoder.matches(changePasswordDto.getOldPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
        }
        else {
            throw new PasswordNotMatchingException(changePasswordDto.getEmail());
        }

        this.userRepository.save(user);
    }

    @Override
    public void changeProfileImage(ChangeProfileImageDto changeProfileImageDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String email = userDetails.getUsername();

        User user = this.findById(email);

        user.setProfileImage(changeProfileImageDto.getProfileImage());

        this.userRepository.save(user);
    }


}
