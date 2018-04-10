package com.parentof.mai.ui.onboarding.user.location;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class UserLocationPresenter<V extends UserLocationContract.View, I extends UserLocationContract.Interactor> extends BasePresenter<V, I> implements UserLocationContract.Presenter<V, I> {

    @Inject
    public UserLocationPresenter(I interactor,
                                 SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onUserLocationSuccess(String location) {
        getView().gotoNextFragment();
    }
    @Override
    public void onLocation(Activity context,int code) {
        try {
            PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
            Intent intent = intentBuilder.build(context);
            // Start the Intent by requesting a result, identified by a request code.
            context.startActivityForResult(intent, code);


        } catch (GooglePlayServicesRepairableException e) {
            GooglePlayServicesUtil
                    .getErrorDialog(e.getConnectionStatusCode(), context, 0);
        } catch (GooglePlayServicesNotAvailableException e) {
            Toast.makeText(context, "Google Play Services is not available.",
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

}
