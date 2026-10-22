package com.multitaskchatbot.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommonController {
    private ChatClient chatClient;

    CommonController(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    @GetMapping("/comman-chat")
    public String chatForAll(@RequestParam("message") String message) {
        return chatClient.prompt().user(message).call().content();


    }
}
