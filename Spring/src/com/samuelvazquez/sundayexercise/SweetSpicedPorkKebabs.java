package com.samuelvazquez.sundayexercise;

import java.util.ArrayList;
import java.util.List;

public class SweetSpicedPorkKebabs implements CookingRecipe{

    private InformationService informationService;
    private int calories;

    public SweetSpicedPorkKebabs() {
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setInformationService(InformationService informationService) {
        this.informationService = informationService;
    }

    @Override
    public String getIngredients() {
        List<String> list = new ArrayList<>();
        list.add("1 teaspoon ground cumin");
        list.add("1 teaspoon ground fenugreek seeds");
        list.add("¼ teaspoon ground cardamom");
        list.add("¼ teaspoon salt");
        list.add("¼ teaspoon freshly ground black pepper");
        list.add("1 pound pork loin chop");
        list.add("½ cup packed fresh basil (24 large leaves)");
        list.add("24 large red globe grapes");
        return list.toString();
    }

    @Override
    public String getNutritionInfo() {
        return "Kcal: " + informationService.getNutritionFacts(getCalories());
    }

    public int getCalories() {
        return calories;
    }

    public double getTotalCost() {
        return 400.00;
    }
}
