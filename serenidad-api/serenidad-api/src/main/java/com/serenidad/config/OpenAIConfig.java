package com.serenidad.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

@Configuration
@ConditionalOnProperty(
        name = "serenidad.ai.enabled",
        havingValue = "true"
)
public class OpenAIConfig {

    @Bean
    OpenAIClient openAIClient() {
        return OpenAIOkHttpClient.fromEnv();
    }
}