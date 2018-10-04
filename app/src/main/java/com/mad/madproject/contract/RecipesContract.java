package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;
import com.mad.madproject.model.Recipe;

import java.util.List;

public interface RecipesContract {
    interface View extends BaseView<Presenter> {
        void displayAllRecipes(List<Recipe> recipes);
    }

    interface Presenter extends BasePresenter {
        void getDetail();
        void retriveMemoryRecipes();
    }
}