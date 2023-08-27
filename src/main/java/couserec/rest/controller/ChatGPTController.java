package couserec.rest.controller;

import couserec.rest.entity.ChatGPT.dto.ChatGPTRequest;
import couserec.rest.entity.ChatGPT.dto.ChatGPTResponse;
import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedGroupCourse;
import couserec.rest.service.ChatGPTService;
import couserec.rest.service.FinishedGroupCourseService;
import couserec.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bot")
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @GetMapping("/{username}/chat")
    public ResponseEntity<Map<String, Object>> chat(@PathVariable String username) {
        Map<String, Object> responseMap = chatGPTService.chatWithGPT(username);
        return ResponseEntity.ok(responseMap);
    }
}


