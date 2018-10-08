package com.mad.madproject.contract;

import com.mad.madproject.BasePresenter;
import com.mad.madproject.BaseView;
import com.mad.madproject.model.Recipe;

public interface DetailContract {

    interface View extends BaseView<DetailContract.Presenter> {

        void loadContent(Recipe recipe);
    }

    interface Presenter extends BasePresenter {

        void fetch(String id);
    }
}
