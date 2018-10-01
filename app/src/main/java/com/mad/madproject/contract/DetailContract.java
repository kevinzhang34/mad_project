package com.mad.madproject.contract;

import com.mad.madproject.basePresenter;
import com.mad.madproject.baseView;

public interface DetailContract {
    interface View extends baseView<RecipesContract.Presenter> {
    }

    interface Presenter extends basePresenter {
        void fetch();
    }
}
