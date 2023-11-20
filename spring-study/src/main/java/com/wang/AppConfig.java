package com.wang;

import com.wang.service.PetService;
import com.wang.service.impl.PetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PetService petService(){
        return new PetServiceImpl();
    }
}
