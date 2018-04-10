package com.parentof.mai.ui.onboarding.user.dob;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserDOBInteractor extends BaseInteractor
        implements UserDOBContract.Interactor {

    @Inject
    public UserDOBInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
