package com.parentof.mai.ui.onboarding.user.email;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserEmailPresenter<V extends UserEmailContract.View, I extends UserEmailContract.Interactor> extends BasePresenter<V, I> implements UserEmailContract.Presenter<V, I> {

    @Inject
    public UserEmailPresenter(I interactor,
                              SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onUserEmailSuccess(String email) {
        getView().gotoNextFragment();
    }
}
