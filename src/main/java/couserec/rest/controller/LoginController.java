package couserec.rest.controller;

import couserec.rest.entity.User;
import couserec.rest.repository.UserRepository;
import couserec.rest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;
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
            String cmuitaccountName = (String) userInfo.get("cmuitaccount_name");
            String studentId = (String) userInfo.get("student_id");

            // Check if the user already exists in the database
            Optional<User> existingUser = userRepository.findByUsername(cmuitaccountName);

            if (existingUser.isPresent()) {
                // User exists, perform sign-in logic here
                return ResponseEntity.ok(userInfo);
            } else {
                // User doesn't exist, create a new user and save to the database
                User newUser = new User();
                newUser.setUsername(cmuitaccountName);
                newUser.setPassword(studentId);
                userRepository.save(newUser);
                return ResponseEntity.ok(userInfo);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

