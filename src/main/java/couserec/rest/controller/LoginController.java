package couserec.rest.controller;

import couserec.rest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok(loginService.getLoginUrl());
    }

    @PostMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam String code) {
        System.out.println("Received code: " + code);
        try {
            Map<String, String> accessToken = loginService.getAccessToken(code);
            return ResponseEntity.ok(accessToken);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/userinfo")
    public ResponseEntity<?> userinfo(@RequestHeader("Authorization") String authorization) {
        try {
            Map<?, ?> userInfo = loginService.getUserInfo(authorization);
            return ResponseEntity.ok(userInfo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

