package com.multitaskchatbot.controller;

import com.multitaskchatbot.model.QuizQuestion;
import com.multitaskchatbot.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizQuestionController {
    private final QuizService quizService;

    public QuizQuestionController(QuizService quizService) {
        this.quizService = quizService;

    }

    @GetMapping("/quiz-list")
    public ResponseEntity<List<QuizQuestion>> getQuiz(@RequestParam("message") String message) {
        return ResponseEntity.ok(quizService.generateQuiz(message));

    }

    @GetMapping("/quiz-stream")
    public ResponseEntity<Flux<String>> simpleQuiz(String message) {
        return ResponseEntity.ok(quizService.generateStreamQuiz(message));

    }
}
