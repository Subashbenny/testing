package com.parentof.mai.ui.onboarding.user.role;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserRoleInteractor extends BaseInteractor
        implements UserRoleContract.Interactor {

    @Inject
    public UserRoleInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
