package com.parentof.mai.ui.onboarding.user.dp;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserDPInteractor extends BaseInteractor
        implements UserDPContract.Interactor {

    @Inject
    public UserDPInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
