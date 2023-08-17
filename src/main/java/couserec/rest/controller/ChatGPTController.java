package couserec.rest.controller;

import couserec.rest.entity.ChatGPT.dto.ChatGPTRequest;
import couserec.rest.entity.ChatGPT.dto.ChatGPTResponse;
import couserec.rest.entity.Course;
import couserec.rest.entity.FinishedCourse;
import couserec.rest.service.FinishedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
    private FinishedCourseService finishedCourseService;

    @GetMapping("/chat")
    public String chat() {

        List<FinishedCourse> finishedCourses = finishedCourseService.getStudentFinishedCourse();

        StringBuilder promptBuilder = new StringBuilder("If I have finished these subjects:");

        for (FinishedCourse finishedCourse : finishedCourses) {
            for (Course course : finishedCourse.getCourses()) {
                promptBuilder.append(" ").append(course.getName()).append(",");
            }
        }

        // Remove the last comma and add the rest of the prompt
        promptBuilder.deleteCharAt(promptBuilder.length() - 1);
        promptBuilder.append(" what should I continue to study?");

        ChatGPTRequest request = new ChatGPTRequest(model, promptBuilder.toString());
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    private List<String> extractCoursesFromPrompt(String prompt) {
        // A simple method to extract course names from the prompt.
        // This can be enhanced with more advanced parsing logic.
        String[] words = prompt.split(" ");
        List<String> courses = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith("se")) { // assuming course names start with "se"
                courses.add(word);
            }
        }
        return courses;
    }
}

