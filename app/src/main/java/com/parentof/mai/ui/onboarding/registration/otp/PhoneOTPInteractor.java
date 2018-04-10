package com.parentof.mai.ui.onboarding.registration.otp;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class PhoneOTPInteractor extends BaseInteractor
        implements PhoneOTPContract.Interactor {

    @Inject
    public PhoneOTPInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
