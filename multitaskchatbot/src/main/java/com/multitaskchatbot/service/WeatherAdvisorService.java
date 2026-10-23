package com.multitaskchatbot.service;

import com.multitaskchatbot.model.WeatherAdvice;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class WeatherAdvisorService {
    private ChatClient chatClient;
    @Value("classpath:/prompts/weather_sys_prompt.st")
    Resource weather_sys_prompt;

    WeatherAdvisorService(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    public WeatherAdvice getAdvice(String message) {
        WeatherAdvice weather = chatClient.prompt()
                .system(weather_sys_prompt)
                .user(message)
                .call()
                .entity(WeatherAdvice.class);
        return weather;

    }

    public Flux<String> getWeatherStream(String message) {
        Flux<String> streamWeather = chatClient.prompt()
                .system(weather_sys_prompt)
                .user(message)
                .stream()
                .content();
        return streamWeather;

    }
}
