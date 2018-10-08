package com.mad.madproject.presenter;

import com.mad.madproject.contract.RecipesContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;

import java.util.List;

public class RecipesPresenter implements RecipesContract.Presenter{

    private final RecipeRemoteDataSource mRecipeDataSource;

    private final RecipesContract.View mView;

    public RecipesPresenter (RecipeRemoteDataSource recipeDataSource, RecipesContract.View view) {
        this.mRecipeDataSource = recipeDataSource;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void getDetail() {

    }

    @Override
    public void retriveRecipes() {
        mRecipeDataSource.retriveRecipes("", new RecipeDataSource.GetRecipeCallback() {

            @Override
            public void onRecipeLoaded(List<Recipe> recipes) {
                mView.displayAllRecipes(recipes);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void start() {

    }
}
