package com.parentof.mai.di.module;

import android.app.Application;
import android.content.Context;

import com.parentof.mai.data.source.local.prefs.AppPreferencesHelper;
import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.di.PreferenceInfo;
import com.parentof.mai.utils.AppConstants;
import com.parentof.mai.utils.rx.AppSchedulerProvider;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by gaurav on 12/06/17.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    static SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PreferenceInfo
    static String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Binds
    @Singleton
    abstract PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper);
}
