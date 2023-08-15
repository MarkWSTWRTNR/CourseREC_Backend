//package couserec.rest.security.controller;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class AuthController {
//
//    @Value("${oauth2.clientId}")
//    private String clientId;
//
//    @Value("${oauth2.clientSecret}")
//    private String clientSecret;
//
//    @Value("${oauth2.tokenUrl}")
//    private String tokenUrl;
//
//    @PostMapping("/api/auth/exchange")
//    public ResponseEntity<?> exchangeCodeForToken(@RequestParam String code) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
//        requestMap.add("code", code);
//        requestMap.add("client_id", clientId);
//        requestMap.add("client_secret", clientSecret);
//        requestMap.add("grant_type", "authorization_code");
//        requestMap.add("redirect_uri", "http://localhost:3000/student_info");
//
//        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, requestMap, String.class);
//
//        System.out.println("OAuth2 Server Response: " + response.getBody()); // Log the response
//
//        return ResponseEntity.ok(response.getBody());
//    }
//
//}
//
