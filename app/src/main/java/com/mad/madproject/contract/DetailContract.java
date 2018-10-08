package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;

public interface DetailContract {

    interface View extends BaseView<RecipesContract.Presenter> {

    }

    interface Presenter extends BasePresenter {

        void fetch();
    }
}
