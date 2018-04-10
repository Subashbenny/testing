package com.parentof.mai.ui.onboarding.registration.begin;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class BeginPresenter<V extends BeginContract.View, I extends BeginContract.Interactor> extends BasePresenter<V, I> implements BeginContract.Presenter<V, I> {

    @Inject
    public BeginPresenter(I interactor,
                          SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onNext() {
        getView().gotoNextFragment();
    }
}
