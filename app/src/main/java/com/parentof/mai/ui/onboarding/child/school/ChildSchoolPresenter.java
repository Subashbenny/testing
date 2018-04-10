package com.parentof.mai.ui.onboarding.child.school;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class ChildSchoolPresenter<V extends ChildSchoolContract.View, I extends ChildSchoolContract.Interactor> extends BasePresenter<V, I> implements ChildSchoolContract.Presenter<V, I> {

    @Inject
    public ChildSchoolPresenter(I interactor,
                                SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onChildSchoolSuccess(String schoolName) {
        getView().gotoNextFragment();
    }
}
