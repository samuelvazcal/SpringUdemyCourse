package com.samuelvazquez.sundayexercise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //CookingRecipe recipe = new ChickenSoupRecipe();
        CookingRecipe recipe = context.getBean("myChickenSoupRecipe",CookingRecipe.class);
        //CookingRecipe recipe1 = context.getBean("mySweetSpicedPorkKebabs",ChickenSoupRecipe.class);
        SweetSpicedPorkKebabs recipe1 = context.getBean("mySweetSpicedPorkKebabs",SweetSpicedPorkKebabs.class);

//        System.out.println(recipe.getIngredients());
//        System.out.println(recipe.getNutritionInfo());
        System.out.println(recipe1.getIngredients());
        System.out.println(recipe1.getNutritionInfo());
        System.out.println(recipe1.getCalories());

        context.close();
    }
}
