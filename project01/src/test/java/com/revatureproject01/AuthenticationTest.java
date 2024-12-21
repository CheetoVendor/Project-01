package com.revatureproject01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.revatureproject01.project01.controller.AuthController;
import com.revatureproject01.project01.entity.Account;
import com.revatureproject01.project01.security.JwtTokenUtil;

public class AuthenticationTest {
    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @InjectMocks
    private AuthController authController;

    private Account testUser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        testUser = new Account();
        testUser.setUsername("test");
        testUser.setPassword("test");
    }

    @Test
    public void testLoginSuccessful() {
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        // Mock JwtTokenUtil behavior
        // when(jwtTokenUtil.generateToken(anyString())).thenReturn("mockJwtToken");

        // Call the login method
        String response = authController.login(testUser);

        // Verify results
        assertEquals("mockJwtToken", response);
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        // verify(jwtTokenUtil).generateToken(anyString());
    }
}
