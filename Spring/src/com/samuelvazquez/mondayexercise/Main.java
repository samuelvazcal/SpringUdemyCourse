package com.samuelvazquez.mondayexercise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mondayReview-applicationContext.xml");

        Challenge pokemonTrainerChallenge = context.getBean("myPokemonTrainerChallenge",Challenge.class);

        System.out.println(pokemonTrainerChallenge.getBreederChallenge());
        System.out.println(pokemonTrainerChallenge.getATip());

        context.close();
    }
}
