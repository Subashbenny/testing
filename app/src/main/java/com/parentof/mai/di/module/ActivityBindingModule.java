package com.parentof.mai.di.module;

import com.parentof.mai.di.ActivityScoped;
import com.parentof.mai.ui.home.HomeActivity;
import com.parentof.mai.ui.home.HomeModule;
import com.parentof.mai.ui.onboarding.child.ChildDataActivity;
import com.parentof.mai.ui.onboarding.child.ChildDataModule;
import com.parentof.mai.ui.onboarding.registration.RegistrationActivity;
import com.parentof.mai.ui.onboarding.registration.RegistrationModule;
import com.parentof.mai.ui.onboarding.user.UserDataActivity;
import com.parentof.mai.ui.onboarding.user.UserDataModule;
import com.parentof.mai.ui.splash.SplashActivity;
import com.parentof.mai.ui.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity splashActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = RegistrationModule.class)
    abstract RegistrationActivity registrationActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = UserDataModule.class)
    abstract UserDataActivity userDataActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ChildDataModule.class)
    abstract ChildDataActivity childDataActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();
}
