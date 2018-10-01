package com.mad.madproject.model.recipeRelated;

import com.mad.madproject.model.Recipe;

import java.util.List;

public interface RecipeDataSource {

    interface GetRecipeCallback {

        void onRecipeLoaded(List<Recipe> recipes);

        void onDataNotAvailable();
    }

    List<Recipe> SearchByIngradians(String Ingradians, GetRecipeCallback callback);
}
