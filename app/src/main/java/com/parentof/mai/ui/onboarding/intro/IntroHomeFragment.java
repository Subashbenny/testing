package com.parentof.mai.ui.onboarding.intro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parentof.mai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroHomeFragment extends Fragment {

    private boolean isViewShown = false;

    public static IntroHomeFragment newInstance() {
        IntroHomeFragment fragment = new IntroHomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_feature_1, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
