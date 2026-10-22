package com.multitaskchatbot.config;

import com.multitaskchatbot.advisors.TokenUsageAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
public class ChatClientConfig {
    @Value("classpath:/prompts/default_sys_prompt.st")
    Resource default_sys_prompt;

    @Value("classpath:/prompts/default_user_prompt.st")
    Resource default_user_prompt;

    @Bean
    public ChatClient chatBoatChatClient(ChatClient.Builder builder) {
        var chatOptions = OpenAiChatOptions.builder().model("gpt-4o-mini").temperature(0.6);
        return builder
                .defaultOptions(chatOptions)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor(), new TokenUsageAdvisor()))
                .defaultSystem(default_sys_prompt)
                .defaultUser(default_user_prompt)
                .build();


    }
}
