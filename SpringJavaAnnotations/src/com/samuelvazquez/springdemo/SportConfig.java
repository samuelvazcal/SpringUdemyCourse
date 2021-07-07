package com.samuelvazquez.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.samuelvazquez.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for our sad motivation service
    @Bean
    public MotivationService sadMotivationService() {
        return new SadMotivationService();
    }

    @Bean
    //define bean for our swim coach AND inject dependency
    public Coach swimCoach() {
        return new SwimCoach(sadMotivationService());
    }

    @Bean
    public Coach basketballCoach() {
        return new BasketballCoach();
    }

}
