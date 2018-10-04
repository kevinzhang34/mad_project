package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;
import com.mad.madproject.exception.NoRecipeException;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void getSearchResult();
        void showNoRecipeException(NoRecipeException e);
    }

    interface Presenter extends BasePresenter {
        void getSearchRecipies(String ingredients);
        void getPopular();
    }
}
