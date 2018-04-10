package com.parentof.mai.ui.onboarding.child.gender;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class ChildGenderInteractor extends BaseInteractor
        implements ChildGenderContract.Interactor {

    @Inject
    public ChildGenderInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
