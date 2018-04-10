package com.parentof.mai.ui.onboarding.child;

import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class ChildDataPresenter<V extends ChildDataContract.View, I extends ChildDataContract.Interactor>
        extends BasePresenter<V, I> implements ChildDataContract.Presenter<V, I> {

    @Inject
    public ChildDataPresenter(I mvpInteractor,
                              SchedulerProvider schedulerProvider) {
        super(mvpInteractor, schedulerProvider);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void setRegistrationScreen() {
        getView().setInitialFragment(ChildDataAdapter.STEP_CHILD_NAME);
        /*if (!getDataManager().isGoogleLoginDone()) {
            getBaseView().setInitialFragment(ChildDataAdapter.STEP_GOOGLE_SIGN_IN);
            return;
        }
        if (!getDataManager().isPhoneNumberDone()) {
            getBaseView().setInitialFragment(ChildDataAdapter.STEP_ENTER_PHONE_NUMBER);
            return;
        }
        getBaseView().setInitialFragment(ChildDataAdapter.STEP_SIGN_IN);*/
    }
}
