package couserec.rest.controller;

import couserec.rest.entity.ChatGPT.dto.ChatGPTRequest;
import couserec.rest.entity.ChatGPT.dto.ChatGPTResponse;
import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedGroupCourse;
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

    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;
    @Autowired
    private FinishedGroupCourseService finishedGroupCourseService;
    @Autowired
    private UserService userService;

    @GetMapping("/{username}/chat")
    public ResponseEntity<Map<String, Object>> chat(@PathVariable String username) {

        List<FinishedGroupCourse> finishedGroupCourses = userService.getCompletedCoursesByUsername(username);

        StringBuilder promptBuilder = new StringBuilder("If I have finished these subjects:");
        List<String> finishedCourseNames = new ArrayList<>();

        for (FinishedGroupCourse finishedGroupCourse : finishedGroupCourses) {
            for (Course course : finishedGroupCourse.getCourses()) {
                promptBuilder.append(" ").append(course.getName()).append(",");
                finishedCourseNames.add(course.getName());
            }
        }

        // Remove the last comma and add the rest of the prompt
        promptBuilder.deleteCharAt(promptBuilder.length() - 1);
        promptBuilder.append(" what should I continue to study?");

        ChatGPTRequest request = new ChatGPTRequest(model, promptBuilder.toString());
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("finishedCourses", finishedCourseNames); // This will show the course names sent to ChatGPT
        responseMap.put("recommendation", chatGPTResponse.getChoices().get(0).getMessage().getContent());

        return ResponseEntity.ok(responseMap);
    }
}


