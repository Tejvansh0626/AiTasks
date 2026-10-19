package com.bank.loansAssitence.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleLoanController {
    private ChatClient chatClient;

    SampleLoanController(ChatClient chatClient) {
        this.chatClient = chatClient;

    }

    @GetMapping("/sampleLoan")
    public String sampleLoanChat(@RequestParam("message") String message) {
        return chatClient.prompt()
                /*.system("""
                        this is loan banking system.....
                        """)*/
                .user(message).call().content();


    }

}
