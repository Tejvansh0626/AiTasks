package com.multitaskchatbot.service;

import com.multitaskchatbot.model.TravelPlan;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class TravelPlannerService {
    private ChatClient chatClient;
    @Value("classpath:/prompts/travel_plan_sys_prompt.st")
    Resource travel_plan_sys_prompt;

    TravelPlannerService(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    public TravelPlan generatePlan(String message) {
        TravelPlan plan = chatClient.prompt()
                .system(travel_plan_sys_prompt)
                .user(message)
                .call()
                .entity(TravelPlan.class);
        return plan;

    }

    public Flux<String> genrateStreamPlan(String message) {
        Flux<String> streamPaln = chatClient.prompt()
                .system(travel_plan_sys_prompt)
                .user(message)
                .stream()
                .content();
        return streamPaln;

    }
}
