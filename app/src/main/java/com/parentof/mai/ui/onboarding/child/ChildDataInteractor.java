package com.parentof.mai.ui.onboarding.child;


import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class ChildDataInteractor extends BaseInteractor
        implements ChildDataContract.Interactor {

    @Inject
    public ChildDataInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
