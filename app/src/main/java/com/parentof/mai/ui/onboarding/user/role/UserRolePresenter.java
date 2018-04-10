package com.parentof.mai.ui.onboarding.user.role;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserRolePresenter<V extends UserRoleContract.View, I extends UserRoleContract.Interactor> extends BasePresenter<V, I> implements UserRoleContract.Presenter<V, I> {

    @Inject
    public UserRolePresenter(I interactor,
                             SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onPhoneNumberSuccess(String phoneNumber) {
        getView().gotoNextFragment();
    }
}
