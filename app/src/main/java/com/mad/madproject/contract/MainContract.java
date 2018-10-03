package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.model.RecipesIntentObject;

import java.util.List;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void getSearchResult(RecipesIntentObject recipes);
    }

    interface Presenter extends BasePresenter {
        void getSearchRecipies(String ingredients);
        void getPopular();
    }
}
