package com.mad.madproject.contract;

import com.mad.madproject.basePresenter;
import com.mad.madproject.baseView;

public interface MainContract {
    interface View extends baseView<Presenter> {
        void search();
        void getPopularRecipe();
    }

    interface Presenter extends basePresenter {
        void getSearch();
        void getPopular();
    }
}
