package com.parentof.mai.ui.onboarding.user.dp;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserDPPresenter<V extends UserDPContract.View, I extends UserDPContract.Interactor> extends BasePresenter<V, I> implements UserDPContract.Presenter<V, I> {

    @Inject
    public UserDPPresenter(I interactor,
                           SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onPhoneNumberSuccess(String phoneNumber) {
        getView().gotoNextFragment();
    }
}
