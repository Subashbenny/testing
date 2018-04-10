package com.parentof.mai.ui.splash;

import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class SplashPresenter<V extends SplashContract.View, I extends SplashContract.Interactor>
        extends BasePresenter<V, I> implements SplashContract.Presenter<V, I> {

    @Inject
    public SplashPresenter(I mvpInteractor,
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
