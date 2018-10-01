package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;

public interface RecipesContract {
    interface View extends BaseView<Presenter> {
        void showDetail();
    }

    interface Presenter extends BasePresenter {
        void getDetail();
    }
}