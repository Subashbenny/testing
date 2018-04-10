package com.parentof.mai.ui.base;


import com.parentof.mai.data.source.local.prefs.PreferencesHelper;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class BaseInteractor implements BaseInteractorContract {

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public BaseInteractor(PreferencesHelper preferencesHelper) {
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }
}
