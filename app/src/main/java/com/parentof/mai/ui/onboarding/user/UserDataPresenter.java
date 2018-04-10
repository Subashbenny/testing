package com.parentof.mai.ui.onboarding.user;

import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class UserDataPresenter<V extends UserDataContract.View, I extends UserDataContract.Interactor>
        extends BasePresenter<V, I> implements UserDataContract.Presenter<V, I> {

    @Inject
    public UserDataPresenter(I mvpInteractor,
                             SchedulerProvider schedulerProvider) {
        super(mvpInteractor, schedulerProvider);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void setRegistrationScreen() {
        getView().setInitialFragment(UserDataAdapter.STEP_USER_NAME);
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
