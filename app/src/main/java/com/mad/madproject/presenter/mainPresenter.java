package com.mad.madproject.presenter;

import com.mad.madproject.contract.MainContract;
import com.mad.madproject.model.recipeRelated.recipeRepository;

import java.util.List;

public class mainPresenter implements MainContract.Presenter{

    private final recipeRepository mRecipeRepository;

    private final MainContract.View mView;

    public mainPresenter(recipeRepository recipeRepository, MainContract.View view) {
        mRecipeRepository = recipeRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void getSearch(String ingredients) {
        mView.openDetailActivity(mRecipeRepository.SearchByIngradians(ingredients));
    }

    @Override
    public void getPopular() {

    }

    @Override
    public void start(){

    }
}
