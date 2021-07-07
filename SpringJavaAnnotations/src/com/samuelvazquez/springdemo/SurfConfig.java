package com.samuelvazquez.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.samuelvazquez.springdemo")

public class SurfConfig {

    @Bean
    public MotivationService finalMotivationService(){
        return new FinalMotivationService();
    }

    @Bean
    public Coach surfCoach() {
        return new SurfCoach(finalMotivationService());
    }

}
