package com.multitaskchatbot.model;

import java.util.List;

public record QuizQuestion(
        String question,
        List<String> options,
        String answer
) {
}
