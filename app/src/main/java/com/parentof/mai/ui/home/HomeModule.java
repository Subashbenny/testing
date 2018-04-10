package com.parentof.mai.ui.home;

import dagger.Binds;
import dagger.Module;

/**
 * Created by gaurav on 15/11/17.
 */

@Module
abstract public class HomeModule {

    @Binds
    abstract HomeContract.Presenter<HomeContract.View, HomeContract.Interactor> provideHomePresenter(
            HomePresenter<HomeContract.View, HomeContract.Interactor> presenter);

    @Binds
    abstract HomeContract.Interactor provideHomeInteractor(HomeInteractor interactor);
}
