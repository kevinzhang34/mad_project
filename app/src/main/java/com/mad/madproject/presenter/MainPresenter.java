package com.mad.madproject.presenter;

import com.mad.madproject.contract.MainContract;
import com.mad.madproject.exception.NoRecipeException;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private final RecipeDataSource mRecipeRepository;

    private final MainContract.View mView;

    public MainPresenter(RecipeRemoteDataSource recipeRepository, MainContract.View view) {
        mRecipeRepository = recipeRepository;
        mView = view;
        // you have to call this so that the view holds the same presenter.
        mView.setPresenter(this);
    }

    @Override
    public void getSearchRecipies(String ingredients) {
        mRecipeRepository.retriveRecipes(ingredients, new RecipeDataSource.GetRecipeCallback() {

            /**
             * called after recipes are loaded
             * @param recipes
             */
            @Override
            public void onRecipeLoaded(List<Recipe> recipes) {
                mView.getSearchResult();
            }

            /**
             * called after recipes are not available due to vary reasons.
             */
            @Override
            public void onDataNotAvailable() {
                mView.showNoRecipeException(new NoRecipeException());
            }
        });
    }

    @Override
    public void getPopular() {

    }

    @Override
    public void start(){}

}
