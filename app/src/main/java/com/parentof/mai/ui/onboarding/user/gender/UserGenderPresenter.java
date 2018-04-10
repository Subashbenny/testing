package com.parentof.mai.ui.onboarding.user.gender;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserGenderPresenter<V extends UserGenderContract.View, I extends UserGenderContract.Interactor> extends BasePresenter<V, I> implements UserGenderContract.Presenter<V, I> {

    @Inject
    public UserGenderPresenter(I interactor,
                               SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onUserGenderSuccess(String gender) {
        getView().gotoNextFragment();
    }
}
