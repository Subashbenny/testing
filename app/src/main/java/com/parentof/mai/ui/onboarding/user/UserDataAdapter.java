package com.parentof.mai.ui.onboarding.user;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.parentof.mai.ui.onboarding.user.dob.UserDOBFragment;
import com.parentof.mai.ui.onboarding.user.dp.UserDPFragment;
import com.parentof.mai.ui.onboarding.user.email.UserEmailFragment;
import com.parentof.mai.ui.onboarding.user.gender.UserGenderFragment;
import com.parentof.mai.ui.onboarding.user.location.UserLocationFragment;
import com.parentof.mai.ui.onboarding.user.name.UserNameFragment;

/**
 * Created by gaurav on 14/06/17.
 */

public class UserDataAdapter extends FragmentStatePagerAdapter {

    public static final int STEP_USER_NAME = 0;
    public static final int STEP_USER_GENDER = 1;
    public static final int STEP_USER_DOB = 2;
    public static final int STEP_USER_LOCATION = 3;
    public static final int STEP_USER_EMAIL = 4;
    public static final int STEP_USER_DP = 5;

    public UserDataAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case STEP_USER_NAME:
                return new UserNameFragment();
            case STEP_USER_GENDER:
                return new UserGenderFragment();
            case STEP_USER_DOB:
                return new UserDOBFragment();
            case STEP_USER_LOCATION:
                return new UserLocationFragment();
            case STEP_USER_EMAIL:
                return new UserEmailFragment();
            case STEP_USER_DP:
                return new UserDPFragment();
        }
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 6;
    }


}
