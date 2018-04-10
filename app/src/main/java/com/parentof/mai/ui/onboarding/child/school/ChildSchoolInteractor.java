package com.parentof.mai.ui.onboarding.child.school;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class ChildSchoolInteractor extends BaseInteractor
        implements ChildSchoolContract.Interactor {

    @Inject
    public ChildSchoolInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
