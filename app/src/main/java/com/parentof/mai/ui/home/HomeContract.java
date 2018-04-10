package com.parentof.mai.ui.home;

import com.parentof.mai.ui.base.BaseInteractorContract;
import com.parentof.mai.ui.base.BasePresenterContract;
import com.parentof.mai.ui.base.BaseViewContract;

/**
 * Created by gaurav on 15/11/17.
 */

public interface HomeContract {

    interface View extends BaseViewContract {
        void openHomeActivity();
        void openOnboardingActivity();
    }

    interface Interactor extends BaseInteractorContract {
    }

    interface Presenter<V extends View,
            I extends Interactor> extends BasePresenterContract<V, I> {
        void initializeApp();
    }
}
