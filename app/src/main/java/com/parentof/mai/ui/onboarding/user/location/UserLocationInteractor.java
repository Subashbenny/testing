package com.parentof.mai.ui.onboarding.user.location;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserLocationInteractor extends BaseInteractor
        implements UserLocationContract.Interactor {

    @Inject
    public UserLocationInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
