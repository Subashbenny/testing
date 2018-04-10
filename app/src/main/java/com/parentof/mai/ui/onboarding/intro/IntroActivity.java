package com.parentof.mai.ui.onboarding.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.parentof.mai.ui.onboarding.registration.RegistrationActivity;

/**
 * Created by gaurav on 08/09/16.
 */
public class IntroActivity extends AppIntro2 {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(IntroHomeFragment.newInstance());
        addSlide(IntroShareFragment.newInstance());
        addSlide(IntroReceiveFragment.newInstance());
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent = RegistrationActivity.getStartIntent(IntroActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = RegistrationActivity.getStartIntent(IntroActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}
