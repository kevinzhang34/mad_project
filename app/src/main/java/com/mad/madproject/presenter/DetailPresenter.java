package com.mad.madproject.presenter;

import com.mad.madproject.contract.DetailContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.recipeRelated.RecipeDataSource;
import com.mad.madproject.model.recipeRelated.remote.RecipeRemoteDataSource;

public class DetailPresenter implements DetailContract.Presenter{

    private final RecipeRemoteDataSource mRecipeRemoteDataSource;

    private final DetailContract.View mView;

    public DetailPresenter (RecipeRemoteDataSource recipeRemoteDataSource, DetailContract.View view) {
        this.mRecipeRemoteDataSource = recipeRemoteDataSource;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void fetch(String id) {
        mRecipeRemoteDataSource.retrieveRecipeDetail(id, new RecipeDataSource.GetRecipeDetailCallback() {
            @Override
            public void onDetailLoaded(Recipe recipe) {
                mView.loadContent(recipe);
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
