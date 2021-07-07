package com.samuelvazquez.sundayexercise;

import java.util.ArrayList;
import java.util.List;

public class ChickenSoupRecipe implements CookingRecipe{

    //define a private field for dependency
    private InformationService informationService;

    public ChickenSoupRecipe(InformationService informationService) {
        this.informationService = informationService;
    }

    @Override
    public String getIngredients() {
        List<String> list = new ArrayList<>();
        list.add("1 tablespoon olive Oil");
        list.add("2 cups diced yellow onion");
        list.add("1/2 teaspoon fine sea salt");
        list.add("1 cup diced carrot (peeled)");
        list.add("4 cups unsalted chicken stock");
        list.add("8 oz cooked skinless chicken breast, diced or shredded");
        return list.toString();
    }

    @Override
    public String getNutritionInfo() {
        return null;
    }


}
