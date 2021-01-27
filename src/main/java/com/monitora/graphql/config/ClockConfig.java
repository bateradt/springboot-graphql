package com.monitora.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

//será utilizado para mockar os testes e ter um melhor controle dos tipos de datas utilizados.

@Configuration
public class ClockConfig {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
