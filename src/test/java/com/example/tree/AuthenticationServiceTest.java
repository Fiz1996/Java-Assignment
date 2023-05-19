package com.example.tree;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.tree.dto.AuthenticationResponse;
import com.example.tree.dto.RegisterRequest;
import com.example.tree.dto.Role;
import com.example.tree.entity.User;
import com.example.tree.repository.UserRepository;
import com.example.tree.service.impl.AuthenticationService;
import com.example.tree.service.impl.JwtService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    private AuthenticationService authenticationService;

    @Before
    public void setUp() {
        authenticationService = new AuthenticationService(userRepository, passwordEncoder, jwtService, authenticationManager);
    }

    @Test
    public void testRegister() {
        // Set up mock repository and services
        RegisterRequest request = new RegisterRequest("John", "Doe", "john.doe@example.com", "password", Role.ROLE_USER);
        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        User savedUser = new User();
        savedUser.setFirstName(request.getFirstName());
        savedUser.setLastName(request.getLastName());
        savedUser.setEmail(request.getEmail());
        savedUser.setPassword("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(jwtService.generateToken(any(User.class))).thenReturn("jwtToken");

        // Call register() method
        AuthenticationResponse response = authenticationService.register(request);

        // Verify result
        assertEquals("jwtToken", response.getToken());
    }
}