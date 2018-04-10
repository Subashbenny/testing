package com.parentof.mai.ui.onboarding.child;

import com.parentof.mai.ui.base.BaseInteractorContract;
import com.parentof.mai.ui.base.BasePresenterContract;
import com.parentof.mai.ui.base.BaseViewContract;

/**
 * Created by gaurav on 15/11/17.
 */

public interface ChildDataContract {

    interface View extends BaseViewContract {
        void setInitialFragment(int screen);
        void openHomeActivity();
    }

    interface Interactor extends BaseInteractorContract {
    }

    interface Presenter<V extends View,
            I extends Interactor> extends BasePresenterContract<V, I> {
        void setRegistrationScreen();
    }
}
