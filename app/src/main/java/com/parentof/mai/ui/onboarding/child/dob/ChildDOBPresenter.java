package com.parentof.mai.ui.onboarding.child.dob;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class ChildDOBPresenter<V extends ChildDOBContract.View, I extends ChildDOBContract.Interactor> extends BasePresenter<V, I> implements ChildDOBContract.Presenter<V, I> {

    @Inject
    public ChildDOBPresenter(I interactor,
                             SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onChildDOBSuccess(String dob) {
        getView().gotoNextFragment();
    }
}
