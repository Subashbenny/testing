package com.parentof.mai.ui.onboarding.registration;


import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class RegistrationInteractor extends BaseInteractor
        implements RegistrationContract.Interactor {

    @Inject
    public RegistrationInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
