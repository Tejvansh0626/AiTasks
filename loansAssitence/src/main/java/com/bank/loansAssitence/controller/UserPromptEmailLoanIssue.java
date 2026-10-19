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
public class UserPromptEmailLoanIssue {
    private ChatClient chatClient;

    UserPromptEmailLoanIssue(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    @Value("classpath:/loan_prompts/customer_prompt_loan_issue_email.st")
    Resource customer_prompt_loan_issue_email;


    @GetMapping("/issue")
    public String emialLoanIssue(@RequestParam("customerName") String customerName,
                                 @RequestParam("customerMessage") String customerMessage) {

        return chatClient.prompt().system("""
                        Loans Related duities are explained....!!! 
                        """)
                .user(emailPromt -> emailPromt.text(customer_prompt_loan_issue_email)
                        .param("customerName", customerName)
                        .param("customerMessage", customerMessage))
                .call().content();


    }
}
