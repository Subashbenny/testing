package com.parentof.mai.ui.onboarding.registration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.parentof.mai.ui.onboarding.registration.begin.BeginFragment;
import com.parentof.mai.ui.onboarding.registration.signin.SignInFragment;
import com.parentof.mai.ui.onboarding.registration.otp.PhoneOTPFragment;
import com.parentof.mai.ui.onboarding.registration.phone.PhoneNumberFragment;

/**
 * Created by gaurav on 14/06/17.
 */

public class RegistrationAdapter extends FragmentStatePagerAdapter {

    public static final int STEP_BEGIN = 0;
    public static final int STEP_ENTER_PHONE_NUMBER = 1;
    public static final int STEP_ENTER_OTP = 2;
    public static final int STEP_SIGN_IN = 3;

    public RegistrationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case STEP_BEGIN:
                return new BeginFragment();
            case STEP_ENTER_PHONE_NUMBER:
                return new PhoneNumberFragment();
            case STEP_ENTER_OTP:
                return new PhoneOTPFragment();
            case STEP_SIGN_IN:
                return new SignInFragment();
        }
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 4;
    }


}
