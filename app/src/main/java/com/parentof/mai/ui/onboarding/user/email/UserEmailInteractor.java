package com.parentof.mai.ui.onboarding.user.email;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserEmailInteractor extends BaseInteractor
        implements UserEmailContract.Interactor {

    @Inject
    public UserEmailInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
