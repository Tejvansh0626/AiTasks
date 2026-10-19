package com.bank.loansAssitence.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SystemPropmptStuffingHomeLoan {
    private ChatClient chatClient;

    SystemPropmptStuffingHomeLoan(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    @Value("classpath:/loan_prompts/sys_prompt_stuffing_home_loans.st")
    Resource sys_prompt_stuffing_home_loans;


    @GetMapping("/homeloan_desc")
    public String homeLoanChat(@RequestParam("customerName") String customerName) {
        return chatClient.prompt()
                .system(sys_prompt_stuffing_home_loans)
                .user(customerName)
                .call().content();


    }
}
