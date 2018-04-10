package com.parentof.mai.ui.onboarding.user;

import android.support.v7.widget.LinearLayoutManager;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.onboarding.user.dob.UserDOBContract;
import com.parentof.mai.ui.onboarding.user.dob.UserDOBFragment;
import com.parentof.mai.ui.onboarding.user.dob.UserDOBInteractor;
import com.parentof.mai.ui.onboarding.user.dob.UserDOBPresenter;
import com.parentof.mai.ui.onboarding.user.dp.UserDPContract;
import com.parentof.mai.ui.onboarding.user.dp.UserDPFragment;
import com.parentof.mai.ui.onboarding.user.dp.UserDPInteractor;
import com.parentof.mai.ui.onboarding.user.dp.UserDPPresenter;
import com.parentof.mai.ui.onboarding.user.email.UserEmailContract;
import com.parentof.mai.ui.onboarding.user.email.UserEmailFragment;
import com.parentof.mai.ui.onboarding.user.email.UserEmailInteractor;
import com.parentof.mai.ui.onboarding.user.email.UserEmailPresenter;
import com.parentof.mai.ui.onboarding.user.gender.UserGenderContract;
import com.parentof.mai.ui.onboarding.user.gender.UserGenderFragment;
import com.parentof.mai.ui.onboarding.user.gender.UserGenderInteractor;
import com.parentof.mai.ui.onboarding.user.gender.UserGenderPresenter;
import com.parentof.mai.ui.onboarding.user.location.UserLocationContract;
import com.parentof.mai.ui.onboarding.user.location.UserLocationFragment;
import com.parentof.mai.ui.onboarding.user.location.UserLocationInteractor;
import com.parentof.mai.ui.onboarding.user.location.UserLocationPresenter;
import com.parentof.mai.ui.onboarding.user.name.UserNameContract;
import com.parentof.mai.ui.onboarding.user.name.UserNameFragment;
import com.parentof.mai.ui.onboarding.user.name.UserNameInteractor;
import com.parentof.mai.ui.onboarding.user.name.UserNamePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
abstract public class UserDataModule {

    @Binds
    abstract UserDataContract.Presenter<UserDataContract.View, UserDataContract.Interactor> provideUserDataPresenter(
            UserDataPresenter<UserDataContract.View, UserDataContract.Interactor> presenter);

    @Binds
    abstract UserDataContract.Interactor provideUserDataInteractor(UserDataInteractor interactor);

    @Provides
    static UserDataAdapter provideUserDataAdapter(UserDataActivity activity) {
        return new UserDataAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    static LinearLayoutManager provideLinearLayoutManager(UserDataActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserNameFragment userNameFragment();

    @Binds
    abstract UserNameContract.Presenter<UserNameContract.View, UserNameContract.Interactor> provideUserNamePresenter(
            UserNamePresenter<UserNameContract.View, UserNameContract.Interactor> presenter);

    @Binds
    abstract UserNameContract.Interactor provideUserNameInteractor(UserNameInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserGenderFragment userGenderFragment();

    @Binds
    abstract UserGenderContract.Presenter<UserGenderContract.View, UserGenderContract.Interactor> provideUserGenderPresenter(
            UserGenderPresenter<UserGenderContract.View, UserGenderContract.Interactor> presenter);

    @Binds
    abstract UserGenderContract.Interactor provideUserGenderInteractor(UserGenderInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserDOBFragment userDOBFragment();

    @Binds
    abstract UserDOBContract.Presenter<UserDOBContract.View, UserDOBContract.Interactor> provideUserDOBPresenter(
            UserDOBPresenter<UserDOBContract.View, UserDOBContract.Interactor> presenter);

    @Binds
    abstract UserDOBContract.Interactor provideUserDOBInteractor(UserDOBInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserDPFragment userDPFragment();

    @Binds
    abstract UserDPContract.Presenter<UserDPContract.View, UserDPContract.Interactor> provideUserDPPresenter(
            UserDPPresenter<UserDPContract.View, UserDPContract.Interactor> presenter);

    @Binds
    abstract UserDPContract.Interactor provideUserDPInteractor(UserDPInteractor interactor);


    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserEmailFragment userEmailFragment();

    @Binds
    abstract UserEmailContract.Presenter<UserEmailContract.View, UserEmailContract.Interactor> provideUserEmailPresenter(
            UserEmailPresenter<UserEmailContract.View, UserEmailContract.Interactor> presenter);

    @Binds
    abstract UserEmailContract.Interactor provideUserEmailInteractor(UserEmailInteractor interactor);


    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserLocationFragment userLocationFragment();

    @Binds
    abstract UserLocationContract.Presenter<UserLocationContract.View, UserLocationContract.Interactor> provideUserLocationPresenter(
            UserLocationPresenter<UserLocationContract.View, UserLocationContract.Interactor> presenter);

    @Binds
    abstract UserLocationContract.Interactor provideUserLocationInteractor(UserLocationInteractor interactor);
}
