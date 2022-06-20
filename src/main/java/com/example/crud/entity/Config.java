package com.example.crud.entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

        private final String p = "Kranthi";



        @Bean(name="p")
        public String getP(){return p;}

    @Bean(name="restTemplate")
    public RestTemplate restTemp(){return new RestTemplate();}


    }
