package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;
import com.mad.madproject.model.recipeRelated.Recipe;

import java.util.List;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void getSearchResult(List<Recipe> recipes);
    }

    interface Presenter extends BasePresenter {
        void getSearchRecipies(String ingredients);
        void getPopular();
    }
}
