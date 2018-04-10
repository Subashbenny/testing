package com.parentof.mai.ui.onboarding.child;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.parentof.mai.ui.onboarding.child.dob.ChildDOBFragment;
import com.parentof.mai.ui.onboarding.child.dp.ChildDPFragment;
import com.parentof.mai.ui.onboarding.child.gender.ChildGenderFragment;
import com.parentof.mai.ui.onboarding.child.name.ChildNameFragment;
import com.parentof.mai.ui.onboarding.child.school.ChildSchoolFragment;

/**
 * Created by gaurav on 14/06/17.
 */

public class ChildDataAdapter extends FragmentStatePagerAdapter {

    public static final int STEP_CHILD_NAME = 0;
    public static final int STEP_CHILD_GENDER = 1;
    public static final int STEP_CHILD_DOB = 2;
    public static final int STEP_CHILD_SCHOOL = 3;
    public static final int STEP_CHILD_DP = 4;

    public ChildDataAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case STEP_CHILD_NAME:
                return new ChildNameFragment();
            case STEP_CHILD_GENDER:
                return new ChildGenderFragment();
            case STEP_CHILD_DOB:
                return new ChildDOBFragment();
            case STEP_CHILD_SCHOOL:
                return new ChildSchoolFragment();
            case STEP_CHILD_DP:
                return new ChildDPFragment();
        }
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 5;
    }


}
