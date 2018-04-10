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
public class IntroShareFragment extends Fragment {


    public static IntroShareFragment newInstance() {
        IntroShareFragment fragment = new IntroShareFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro_feature_2, container, false);
    }

}
