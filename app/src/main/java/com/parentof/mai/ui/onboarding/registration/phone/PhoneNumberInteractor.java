package com.parentof.mai.ui.onboarding.registration.phone;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class PhoneNumberInteractor extends BaseInteractor
        implements PhoneNumberContract.Interactor {

    @Inject
    public PhoneNumberInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
