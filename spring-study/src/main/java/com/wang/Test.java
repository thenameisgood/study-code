package com.wang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Test {
    
    @Bean("testBean")
    public TestBean getTestBean(){
        return new TestBean();
    }
}
