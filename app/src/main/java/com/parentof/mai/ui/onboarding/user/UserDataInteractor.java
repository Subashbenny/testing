package com.parentof.mai.ui.onboarding.user;


import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class UserDataInteractor extends BaseInteractor
        implements UserDataContract.Interactor {

    @Inject
    public UserDataInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
