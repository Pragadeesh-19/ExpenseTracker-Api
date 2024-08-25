package org.pragadeesh.secjwt.controller;

import org.pragadeesh.secjwt.model.JwtResonse;
import org.pragadeesh.secjwt.model.User;
import org.pragadeesh.secjwt.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResonse> login(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }
}
