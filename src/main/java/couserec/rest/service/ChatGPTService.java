package couserec.rest.service;

import java.util.Map;

public interface ChatGPTService {
    Map<String, Object> chatWithGPT(String username);
}
