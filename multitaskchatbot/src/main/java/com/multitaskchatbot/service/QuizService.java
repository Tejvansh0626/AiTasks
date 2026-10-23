package com.multitaskchatbot.service;

import com.multitaskchatbot.model.QuizQuestion;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class QuizService {
    @Value("classpath:/prompts/quiz_sys_prompt.st")
    Resource quiz_sys_prompt;
    private ChatClient chatClient;

    QuizService(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    // Generate structured quiz questions
    public List<QuizQuestion> generateQuiz(String message) {
        return chatClient.prompt()
                .system(quiz_sys_prompt)
                .user(message)
                .call()
                .entity(new ParameterizedTypeReference<List<QuizQuestion>>() {
                });

    }

    //Generate simple string questions using stream

    public Flux<String> generateStreamQuiz(String message) {
        return chatClient.prompt()
                .system(quiz_sys_prompt)
                .user(message)
                .stream()
                .content();

    }


}
