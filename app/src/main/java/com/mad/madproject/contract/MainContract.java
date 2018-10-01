package com.mad.madproject.contract;

import com.mad.madproject.basePresenter;
import com.mad.madproject.baseView;
import com.mad.madproject.model.recipe;

import java.util.List;

public interface MainContract {
    interface View extends baseView<Presenter> {
        void search();
        void getPopularRecipe();
        void openDetailActivity(List<recipe> recipes);
    }

    interface Presenter extends basePresenter {
        void getSearch(String ingredients);
        void getPopular();
    }
}
