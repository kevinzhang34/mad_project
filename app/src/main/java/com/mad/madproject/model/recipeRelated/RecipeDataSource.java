package com.mad.madproject.model.recipeRelated;

import com.mad.madproject.exception.NoRecipeException;
import com.mad.madproject.model.OneRecipeReponseBody;
import com.mad.madproject.model.Recipe;

import java.util.List;

public interface RecipeDataSource {

    interface GetRecipeCallback {

        void onRecipeLoaded(List<Recipe> recipes);

        void onDataNotAvailable();
    }

    interface GetRecipeDetailCallback {

        void onDetailLoaded(Recipe recipe);

        void onDataNotAvailable();
    }

    void retriveRecipes(String Ingradians, GetRecipeCallback callback) throws NoRecipeException;

    void retrieveRecipeDetail(String id, GetRecipeDetailCallback callback) throws NoRecipeException;
}
