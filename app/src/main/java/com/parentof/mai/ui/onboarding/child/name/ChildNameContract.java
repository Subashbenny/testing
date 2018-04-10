package com.parentof.mai.ui.onboarding.child.name;

import com.parentof.mai.ui.base.BaseInteractorContract;
import com.parentof.mai.ui.base.BasePresenterContract;
import com.parentof.mai.ui.base.BaseViewContract;

/**
 * Created by gaurav on 20/01/18.
 */

public interface ChildNameContract {

    public interface View extends BaseViewContract {
        void gotoNextFragment();
    }

    public interface Interactor extends BaseInteractorContract {
    }

    public interface Presenter<V extends View, I extends Interactor> extends BasePresenterContract<V, I> {
        void onChildNameSuccess(String firstName, String lastName);
    }
}
