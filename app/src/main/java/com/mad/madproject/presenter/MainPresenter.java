package com.mad.madproject.presenter;

import com.mad.madproject.contract.MainContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.RecipesIntentObject;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, RecipeDataSource.GetRecipeCallback {

    private final RecipeRemoteDataSource mRecipeRepository;

    private final MainContract.View mView;

    public MainPresenter(RecipeRemoteDataSource recipeRepository, MainContract.View view) {
        mRecipeRepository = recipeRepository;
        mView = view;
        // you have to call this so that the view holds the same presenter.
        mView.setPresenter(this);
    }

    @Override
    public void getSearchRecipies(String ingredients) {
        mRecipeRepository.SearchByIngradians(ingredients, this);
    }

    @Override
    public void getPopular() {

    }

    @Override
    public void start(){}

    /**
     * callback method of the recipe callback.
     * @param recipes
     */
    @Override
    public void onRecipeLoaded(List<Recipe> recipes) {
        RecipesIntentObject recipesIntentObject = new RecipesIntentObject(recipes);
        mView.getSearchResult(recipesIntentObject);
    }

    @Override
    public void onDataNotAvailable() {

    }
}
