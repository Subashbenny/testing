package com.parentof.mai.ui.onboarding.child.name;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class ChildNameInteractor extends BaseInteractor
        implements ChildNameContract.Interactor {

    @Inject
    public ChildNameInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
