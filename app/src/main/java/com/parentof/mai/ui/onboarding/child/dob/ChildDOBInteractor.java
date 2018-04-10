package com.parentof.mai.ui.onboarding.child.dob;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class ChildDOBInteractor extends BaseInteractor
        implements ChildDOBContract.Interactor {

    @Inject
    public ChildDOBInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
