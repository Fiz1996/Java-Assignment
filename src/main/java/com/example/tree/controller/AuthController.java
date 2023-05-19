package com.example.tree.controller;

import com.example.tree.dto.AuthenticationRequest;
import com.example.tree.dto.AuthenticationResponse;
import com.example.tree.dto.RegisterRequest;
import com.example.tree.service.impl.AuthenticationService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/loggIn")
    public ResponseEntity<AuthenticationResponse> loggIn (@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authentication(request));
    }
}
