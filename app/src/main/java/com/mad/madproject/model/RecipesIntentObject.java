package com.mad.madproject.model;

import java.io.Serializable;
import java.util.List;

public class RecipesIntentObject implements Serializable {

    List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public RecipesIntentObject(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}
