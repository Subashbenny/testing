package com.parentof.mai.ui.onboarding.user.dob;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserDOBPresenter<V extends UserDOBContract.View, I extends UserDOBContract.Interactor> extends BasePresenter<V, I> implements UserDOBContract.Presenter<V, I> {

    @Inject
    public UserDOBPresenter(I interactor,
                            SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onUserDOBSuccess(String dob) {
        getView().gotoNextFragment();
    }
}
