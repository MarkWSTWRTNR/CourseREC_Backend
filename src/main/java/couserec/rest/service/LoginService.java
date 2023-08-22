package couserec.rest.service;

import couserec.rest.entity.User;

import java.util.Map;

public interface LoginService {
    String getLoginUrl();

    Map<String, String> getAccessToken(String code);

    Map<?, ?> getUserInfo(String authorization);

    void assignUserRole(User user, String username);
}
