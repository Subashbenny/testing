package com.parentof.mai.di.component;

import android.app.Application;

import com.parentof.mai.MaiApp;
import com.parentof.mai.data.source.local.db.DatabaseModule;
import com.parentof.mai.di.module.ActivityBindingModule;
import com.parentof.mai.di.module.ApiServiceModule;
import com.parentof.mai.di.module.ApplicationModule;
import com.parentof.mai.di.module.DataModule;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by gaurav on 12/06/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, ActivityBindingModule.class, DatabaseModule.class, DataModule.class, ApiServiceModule.class})
public interface ApplicationComponent extends AndroidInjector<MaiApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();

    }

    SchedulerProvider getSchedulerProvider();
}
