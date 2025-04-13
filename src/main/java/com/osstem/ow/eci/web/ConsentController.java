package com.osstem.ow.eci.web;

import com.osstem.ow.eci.application.ConsentService;
import com.osstem.ow.eci.domain.ConsentResponse;
import com.osstem.ow.eci.domain.JwtService;
import com.osstem.ow.eci.domain.SessionRequest;
import com.osstem.ow.eci.domain.SignInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("consent")
public class ConsentController {

    private final ConsentService consentService;
    private final JwtService jwtService;

    public ConsentController(ConsentService consentService, JwtService jwtService) {
        this.consentService = consentService;
        this.jwtService = jwtService;
    }

    @GetMapping("baseInfo")
    public ResponseEntity<Object> getBaseInfo(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie token = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("authToken"))
                .findFirst().get();
        SessionRequest sessionRequest= jwtService.parseToken(token.getValue());
        ConsentResponse response = consentService.getUserInfo(sessionRequest.id(), sessionRequest.password());

        return ResponseEntity.ok(response);
    }

    @PostMapping("verify")
    public ResponseEntity<Object> verify(@RequestBody SignInfo signInfo) {
        return null;
    }

    @PostMapping("send")
    public ResponseEntity<Object> send(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie token = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("authToken"))
                .findFirst().get();
        SessionRequest sessionRequest= jwtService.parseToken(token.getValue());
        ConsentResponse response = consentService.getUserInfo(sessionRequest.id(), sessionRequest.password());

        return null;
    }

    @PostMapping("callback")
    public ResponseEntity<Object> callback(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie token = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("authToken"))
                .findFirst().get();
        SessionRequest sessionRequest= jwtService.parseToken(token.getValue());
        Object response = consentService.callback(sessionRequest.id(), sessionRequest.password());
        return ResponseEntity.ok(response);
    }
}
