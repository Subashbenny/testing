package com.parentof.mai.ui.onboarding.user.name;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserNameInteractor extends BaseInteractor
        implements UserNameContract.Interactor {

    @Inject
    public UserNameInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
