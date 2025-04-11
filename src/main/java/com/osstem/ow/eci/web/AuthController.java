package com.osstem.ow.eci.web;

import com.osstem.ow.eci.application.AuthService;
import com.osstem.ow.eci.domain.SessionRequest;
import com.osstem.ow.eci.domain.SessionResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("auth")
    public ResponseEntity<Object> createSession(@RequestBody SessionRequest request, HttpServletResponse httpServletResponse) {
        SessionResponse response = authService.createSession(request.id(), request.password());
        Cookie cookie = new Cookie("authToken", response.token());
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        return ResponseEntity.ok()
                .body(response);
    }




}
