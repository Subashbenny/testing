package com.parentof.mai.ui.onboarding.user.name;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserNamePresenter<V extends UserNameContract.View, I extends UserNameContract.Interactor> extends BasePresenter<V, I> implements UserNameContract.Presenter<V, I> {

    @Inject
    public UserNamePresenter(I interactor,
                             SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onUserNameSuccess(String firstName, String lastName) {
        getView().gotoNextFragment();
    }
}
