package com.parentof.mai.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseActivity;
import com.parentof.mai.ui.onboarding.intro.IntroActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by gaurav on 15/11/17.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mPresenter.initializeApp();
    }

    @Override
    public void openHomeActivity() {
        /*Intent intent = HomeActivity.getStartIntent(OnboardingActivity.this);
        startActivity(intent);
        finish();*/
    }

    @Override
    public void openOnboardingActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = IntroActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
