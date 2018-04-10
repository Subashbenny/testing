package com.parentof.mai.ui.onboarding.user.gender;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class UserGenderInteractor extends BaseInteractor
        implements UserGenderContract.Interactor {

    @Inject
    public UserGenderInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
