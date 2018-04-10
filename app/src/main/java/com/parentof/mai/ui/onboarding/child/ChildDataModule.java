package com.parentof.mai.ui.onboarding.child;

import android.support.v7.widget.LinearLayoutManager;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.onboarding.child.dob.ChildDOBContract;
import com.parentof.mai.ui.onboarding.child.dob.ChildDOBFragment;
import com.parentof.mai.ui.onboarding.child.dob.ChildDOBInteractor;
import com.parentof.mai.ui.onboarding.child.dob.ChildDOBPresenter;
import com.parentof.mai.ui.onboarding.child.dp.ChildDPContract;
import com.parentof.mai.ui.onboarding.child.dp.ChildDPFragment;
import com.parentof.mai.ui.onboarding.child.dp.ChildDPInteractor;
import com.parentof.mai.ui.onboarding.child.dp.ChildDPPresenter;
import com.parentof.mai.ui.onboarding.child.gender.ChildGenderContract;
import com.parentof.mai.ui.onboarding.child.gender.ChildGenderFragment;
import com.parentof.mai.ui.onboarding.child.gender.ChildGenderInteractor;
import com.parentof.mai.ui.onboarding.child.gender.ChildGenderPresenter;
import com.parentof.mai.ui.onboarding.child.name.ChildNameContract;
import com.parentof.mai.ui.onboarding.child.name.ChildNameFragment;
import com.parentof.mai.ui.onboarding.child.name.ChildNameInteractor;
import com.parentof.mai.ui.onboarding.child.name.ChildNamePresenter;
import com.parentof.mai.ui.onboarding.child.school.ChildSchoolContract;
import com.parentof.mai.ui.onboarding.child.school.ChildSchoolFragment;
import com.parentof.mai.ui.onboarding.child.school.ChildSchoolInteractor;
import com.parentof.mai.ui.onboarding.child.school.ChildSchoolPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
abstract public class ChildDataModule {

    @Binds
    abstract ChildDataContract.Presenter<ChildDataContract.View, ChildDataContract.Interactor> provideChildDataPresenter(
            ChildDataPresenter<ChildDataContract.View, ChildDataContract.Interactor> presenter);

    @Binds
    abstract ChildDataContract.Interactor provideChildDataInteractor(ChildDataInteractor interactor);

    @Provides
    static ChildDataAdapter provideChildDataAdapter(ChildDataActivity activity) {
        return new ChildDataAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    static LinearLayoutManager provideLinearLayoutManager(ChildDataActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChildNameFragment childNameFragment();

    @Binds
    abstract ChildNameContract.Presenter<ChildNameContract.View, ChildNameContract.Interactor> provideChildNamePresenter(
            ChildNamePresenter<ChildNameContract.View, ChildNameContract.Interactor> presenter);

    @Binds
    abstract ChildNameContract.Interactor provideChildNameInteractor(ChildNameInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChildGenderFragment childGenderFragment();

    @Binds
    abstract ChildGenderContract.Presenter<ChildGenderContract.View, ChildGenderContract.Interactor> provideChildGenderPresenter(
            ChildGenderPresenter<ChildGenderContract.View, ChildGenderContract.Interactor> presenter);

    @Binds
    abstract ChildGenderContract.Interactor provideChildGenderInteractor(ChildGenderInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChildDOBFragment ChildDOBFragment();

    @Binds
    abstract ChildDOBContract.Presenter<ChildDOBContract.View, ChildDOBContract.Interactor> provideChildDOBPresenter(
            ChildDOBPresenter<ChildDOBContract.View, ChildDOBContract.Interactor> presenter);

    @Binds
    abstract ChildDOBContract.Interactor provideChildDOBInteractor(ChildDOBInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChildDPFragment ChildDPFragment();

    @Binds
    abstract ChildDPContract.Presenter<ChildDPContract.View, ChildDPContract.Interactor> provideChildDPPresenter(
            ChildDPPresenter<ChildDPContract.View, ChildDPContract.Interactor> presenter);

    @Binds
    abstract ChildDPContract.Interactor provideChildDPInteractor(ChildDPInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChildSchoolFragment ChildSchoolFragment();

    @Binds
    abstract ChildSchoolContract.Presenter<ChildSchoolContract.View, ChildSchoolContract.Interactor> provideChildSchoolPresenter(
            ChildSchoolPresenter<ChildSchoolContract.View, ChildSchoolContract.Interactor> presenter);

    @Binds
    abstract ChildSchoolContract.Interactor provideChildSchoolInteractor(ChildSchoolInteractor interactor);
}
