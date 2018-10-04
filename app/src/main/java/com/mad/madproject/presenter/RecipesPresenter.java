package com.mad.madproject.presenter;

import com.mad.madproject.contract.RecipesContract;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;

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
    public void retriveMemoryRecipes() {
        mView.displayAllRecipes(mRecipeDataSource.getRecipes());
    }

    @Override
    public void start() {

    }
}
