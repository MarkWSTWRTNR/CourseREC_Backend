package couserec.rest.service;

import java.util.Map;

public interface LoginService {
    String getLoginUrl();

    Map<String, String> getAccessToken(String code);

    Map<?, ?> getUserInfo(String authorization);
}
