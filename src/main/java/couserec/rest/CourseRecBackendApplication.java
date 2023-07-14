package couserec.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CourseRecBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseRecBackendApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("POST","GET","OPTIONS","DELETE","PUT")
                        .allowedOrigins("http://localhost:3000")
                        .exposedHeaders("x-total-count");

            }
        };

    }
}
