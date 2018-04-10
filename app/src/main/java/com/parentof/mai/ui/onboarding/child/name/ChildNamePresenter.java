package com.parentof.mai.ui.onboarding.child.name;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class ChildNamePresenter<V extends ChildNameContract.View, I extends ChildNameContract.Interactor> extends BasePresenter<V, I> implements ChildNameContract.Presenter<V, I> {

    @Inject
    public ChildNamePresenter(I interactor,
                              SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onChildNameSuccess(String firstName, String lastName) {
        getView().gotoNextFragment();
    }
}
