package com.parentof.mai.ui.onboarding.registration.begin;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class BeginInteractor extends BaseInteractor
        implements BeginContract.Interactor {

    @Inject
    public BeginInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
