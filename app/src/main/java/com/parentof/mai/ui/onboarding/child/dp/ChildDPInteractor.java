package com.parentof.mai.ui.onboarding.child.dp;

import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 05/12/17.
 */

public class ChildDPInteractor extends BaseInteractor
        implements ChildDPContract.Interactor {

    @Inject
    public ChildDPInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
