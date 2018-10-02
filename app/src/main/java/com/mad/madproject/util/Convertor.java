package com.mad.madproject.util;

import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public Convertor(){}

    public static String convertListToString(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strings.size(); i++) {
            stringBuilder.append(strings.get(i));
            if (i != strings.size() - 1) stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public static Recipe[] convertListToArray(List<Recipe> recipes) {
        Recipe[] recipes1 = new Recipe[recipes.size()];
        for (int i = 0; i < recipes.size(); i++){
            recipes1[i] = recipes.get(i);
        }
        return recipes1;
    }

    public static List<Recipe> SResBodyToList(ResponseBody body) {
        List<Recipe> recipes = new ArrayList<>();
        for (Recipe recipe: body.getRecipes()) recipes.add(recipe);
        return recipes;
    }
}
