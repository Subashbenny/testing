package com.parentof.mai.ui.home;

import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class HomePresenter<V extends HomeContract.View, I extends HomeContract.Interactor>
        extends BasePresenter<V, I> implements HomeContract.Presenter<V, I> {

    @Inject
    public HomePresenter(I mvpInteractor,
                         SchedulerProvider schedulerProvider) {
        super(mvpInteractor, schedulerProvider);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void initializeApp() {
        getView().openOnboardingActivity();
    }
}
