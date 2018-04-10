package com.parentof.mai.ui.onboarding.child.gender;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class ChildGenderPresenter<V extends ChildGenderContract.View, I extends ChildGenderContract.Interactor> extends BasePresenter<V, I> implements ChildGenderContract.Presenter<V, I> {

    @Inject
    public ChildGenderPresenter(I interactor,
                                SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onChildGenderSuccess(String gender) {
        getView().gotoNextFragment();
    }
}
