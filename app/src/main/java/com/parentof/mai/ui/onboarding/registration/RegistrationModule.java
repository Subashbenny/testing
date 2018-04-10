package com.parentof.mai.ui.onboarding.registration;

import android.support.v7.widget.LinearLayoutManager;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.onboarding.registration.begin.BeginContract;
import com.parentof.mai.ui.onboarding.registration.begin.BeginFragment;
import com.parentof.mai.ui.onboarding.registration.begin.BeginInteractor;
import com.parentof.mai.ui.onboarding.registration.begin.BeginPresenter;
import com.parentof.mai.ui.onboarding.registration.otp.PhoneOTPContract;
import com.parentof.mai.ui.onboarding.registration.otp.PhoneOTPFragment;
import com.parentof.mai.ui.onboarding.registration.otp.PhoneOTPInteractor;
import com.parentof.mai.ui.onboarding.registration.otp.PhoneOTPPresenter;
import com.parentof.mai.ui.onboarding.registration.phone.PhoneNumberContract;
import com.parentof.mai.ui.onboarding.registration.phone.PhoneNumberFragment;
import com.parentof.mai.ui.onboarding.registration.phone.PhoneNumberInteractor;
import com.parentof.mai.ui.onboarding.registration.phone.PhoneNumberPresenter;
import com.parentof.mai.ui.onboarding.registration.signin.SignInContract;
import com.parentof.mai.ui.onboarding.registration.signin.SignInFragment;
import com.parentof.mai.ui.onboarding.registration.signin.SignInInteractor;
import com.parentof.mai.ui.onboarding.registration.signin.SignInPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
abstract public class RegistrationModule {

    @Binds
    abstract RegistrationContract.Presenter<RegistrationContract.View, RegistrationContract.Interactor> provideRegistrationPresenter(
            RegistrationPresenter<RegistrationContract.View, RegistrationContract.Interactor> presenter);

    @Binds
    abstract RegistrationContract.Interactor provideRegistrationInteractor(RegistrationInteractor interactor);

    @Provides
    static RegistrationAdapter provideRegistrationAdapter(RegistrationActivity activity) {
        return new RegistrationAdapter(activity.getSupportFragmentManager());
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract PhoneNumberFragment phoneNumberFragment();

    @Binds
    abstract PhoneNumberContract.Presenter<PhoneNumberContract.View, PhoneNumberContract.Interactor> providePhoneNumberPresenter(
            PhoneNumberPresenter<PhoneNumberContract.View, PhoneNumberContract.Interactor> presenter);

    @Binds
    abstract PhoneNumberContract.Interactor providePhoneNumberInteractor(PhoneNumberInteractor interactor);

    @Provides
    static LinearLayoutManager provideLinearLayoutManager(RegistrationActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract PhoneOTPFragment phoneOTPFragment();

    @Binds
    abstract PhoneOTPContract.Presenter<PhoneOTPContract.View, PhoneOTPContract.Interactor> providePhoneOTPPresenter(
            PhoneOTPPresenter<PhoneOTPContract.View, PhoneOTPContract.Interactor> presenter);

    @Binds
    abstract PhoneOTPContract.Interactor providePhoneOTPInteractor(PhoneOTPInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SignInFragment googleSignInFragment();

    @Binds
    abstract SignInContract.Presenter<SignInContract.View, SignInContract.Interactor> provideGoogleSignInPresenter(
            SignInPresenter<SignInContract.View, SignInContract.Interactor> presenter);

    @Binds
    abstract SignInContract.Interactor provideGoogleSignInInteractor(SignInInteractor interactor);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract BeginFragment beginFragment();

    @Binds
    abstract BeginContract.Presenter<BeginContract.View, BeginContract.Interactor> provideBeginContract(
            BeginPresenter<BeginContract.View, BeginContract.Interactor> presenter);

    @Binds
    abstract BeginContract.Interactor provideBeginInteractor(BeginInteractor interactor);
}
