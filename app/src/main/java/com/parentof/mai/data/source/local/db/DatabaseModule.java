package com.parentof.mai.data.source.local.db;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.parentof.mai.utils.AppConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gaurav on 22/11/17.
 */

@Module
public abstract class DatabaseModule {

    private static final String DATABASE = "database_name";

    @Provides
    @Named(DATABASE)
    static String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Singleton
    @Provides
    static MaiDatabase provideCoinInDatabase(Application context, @Named(DATABASE) String databaseName) {
        return Room.databaseBuilder(context.getApplicationContext(), MaiDatabase.class, databaseName).build();
    }
}
