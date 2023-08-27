package couserec.rest.controller;

import couserec.rest.entity.User;
import couserec.rest.repository.UserRepository;
import couserec.rest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

            Optional<User> existingUser = userRepository.findByUsername(cmuitaccountName);

            if (existingUser.isPresent()) {
                User user = existingUser.get();
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("userInfo", userInfo);
                responseMap.put("role", user.getRole());
                return ResponseEntity.ok(responseMap);
            } else {

                User newUser = new User();
                newUser.setUsername(cmuitaccountName);
                newUser.setPassword(studentId);

                loginService.assignUserRole(newUser, cmuitaccountName);

                userRepository.save(newUser);

                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("userInfo", userInfo);
                responseMap.put("role", newUser.getRole());
                return ResponseEntity.ok(responseMap);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

