package com.parentof.mai.ui.onboarding.registration.signin;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class SignInInteractor extends BaseInteractor
        implements SignInContract.Interactor {

    @Inject
    public SignInInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
