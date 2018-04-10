package com.parentof.mai.ui.splash;


import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class SplashInteractor extends BaseInteractor
        implements SplashContract.Interactor {

    @Inject
    public SplashInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
