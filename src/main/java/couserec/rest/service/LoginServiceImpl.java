package couserec.rest.service;

import couserec.rest.entity.user.User;
import couserec.rest.entity.user.UserRole;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String CLIENT_ID = "09924PuMCdFKpWXhwqfZsy1rw8Xhx94d51bBCJzh";
    private static final String CLIENT_SECRET = "MjNmwQjEV4xf3GQBjVG52mpDjCRyUvSX08ngWR5S";
    private static final String REDIRECT_URI = "http://localhost:3000/userInfo";
    private static final String TOKEN_ENDPOINT = "https://oauth.cmu.ac.th/v1/GetToken.aspx";
    private static final String USERINFO_ENDPOINT = "https://misapi.cmu.ac.th/cmuitaccount/v1/api/cmuitaccount/basicinfo";

    @Override
    public String getLoginUrl() {
        return "https://oauth.cmu.ac.th/v1/Authorize.aspx?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&scope=cmuitaccount.basicinfo";
    }

    @Override
    public Map<String, String> getAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("code", code);
        formData.add("redirect_uri", REDIRECT_URI);
        formData.add("client_id", CLIENT_ID);
        formData.add("client_secret", CLIENT_SECRET);
        formData.add("grant_type", "authorization_code");

        ResponseEntity<Map> response = restTemplate.postForEntity(TOKEN_ENDPOINT, formData, Map.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            String accessToken = (String) response.getBody().get("access_token");
            if (accessToken != null) {
                return Collections.singletonMap("access_token", accessToken);
            }
        }
        throw new RuntimeException("Failed to get access token.");
    }

    @Override
    public Map<?, ?> getUserInfo(String authorization) {
        String accessToken = authorization.substring(7);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Map> response = restTemplate.exchange(USERINFO_ENDPOINT, HttpMethod.GET, entity, Map.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch user information.");
        }
    }
@Override
    public void assignUserRole(User user, String username) {
        if ("wongsathorn_w".equals(username)) {
            user.setRole(UserRole.ROLE_ADMIN);
        } else {
            user.setRole(UserRole.ROLE_STUDENT);
        }
    }
}

