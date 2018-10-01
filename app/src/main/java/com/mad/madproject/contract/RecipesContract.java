package com.mad.madproject.contract;

import com.mad.madproject.basePresenter;
import com.mad.madproject.baseView;

public interface RecipesContract {
    interface View extends baseView<Presenter> {
    }

    interface Presenter extends basePresenter {
    }
}