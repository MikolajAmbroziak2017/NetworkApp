package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @Bean
    public CommandLineRunner run() {
        return args -> showComments();
    }
private static void showComments(){
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Comment>> response = restTemplate.exchange(
            "http://jsonplaceholder.typicode.com/comments",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Comment>>(){});
    List<Comment> comments = response.getBody();
    if(comments == null) {
        return;
    }

    for(Comment comment : comments) {
        System.out.println(comment.toString());
    }}
}


