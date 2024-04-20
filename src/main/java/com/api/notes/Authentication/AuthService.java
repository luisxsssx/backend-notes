package com.api.notes.Authentication;

import com.api.notes.JWT.JwtService;
import com.api.notes.Model.Role;
import com.api.notes.Model.UserModel;
import com.api.notes.Repository.UserRepo;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepo.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        UserModel user = UserModel.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .first_name(request.getFirst_name())
                .last_name(request.last_name)
                .email(request.getEmail())
                .role(Role.USER)
                .build();

        userRepo.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}
