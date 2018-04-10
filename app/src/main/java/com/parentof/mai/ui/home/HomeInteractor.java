package com.parentof.mai.ui.home;


import com.parentof.mai.data.source.local.prefs.PreferencesHelper;
import com.parentof.mai.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by gaurav on 18/11/17.
 */

public class HomeInteractor extends BaseInteractor
        implements HomeContract.Interactor {

    @Inject
    public HomeInteractor(PreferencesHelper preferencesHelper) {
        super(preferencesHelper);
    }
}
