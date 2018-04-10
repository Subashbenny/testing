package com.parentof.mai.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by gaurav on 15/11/17.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @Inject
    HomeContract.Presenter<HomeContract.View, HomeContract.Interactor> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(HomeActivity.this);

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
    }
}
