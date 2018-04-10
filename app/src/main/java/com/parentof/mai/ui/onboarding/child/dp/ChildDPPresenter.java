package com.parentof.mai.ui.onboarding.child.dp;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class ChildDPPresenter<V extends ChildDPContract.View, I extends ChildDPContract.Interactor> extends BasePresenter<V, I> implements ChildDPContract.Presenter<V, I> {

    @Inject
    public ChildDPPresenter(I interactor,
                            SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onPhoneNumberSuccess(String phoneNumber) {
        getView().gotoNextFragment();
    }
}
