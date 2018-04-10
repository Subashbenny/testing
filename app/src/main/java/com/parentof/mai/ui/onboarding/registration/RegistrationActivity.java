package com.parentof.mai.ui.onboarding.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseActivity;
import com.parentof.mai.ui.base.NonSwipeableViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 15/11/17.
 */

public class RegistrationActivity extends BaseActivity implements RegistrationContract.View, FragmentCallback {

    @Inject
    RegistrationContract.Presenter<RegistrationContract.View, RegistrationContract.Interactor> mPresenter;

    @BindView(R.id.registration_pager)
    NonSwipeableViewPager mViewPager;

    @Inject
    RegistrationAdapter mRegistrationAdapter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(RegistrationActivity.this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mViewPager.setAdapter(mRegistrationAdapter);
        mPresenter.setRegistrationScreen();
    }

    @Override
    public void openHomeActivity() {
        /*Intent intent = HomeActivity.getStartIntent(OnboardingActivity.this);
        startActivity(intent);
        finish();*/
    }

    @Override
    public void gotoStepperScreen(int screen) {
        mViewPager.setCurrentItem(screen);
    }

    @Override
    public void finishRegistration() {

    }

    @Override
    public void setInitialFragment(int screen) {
        gotoStepperScreen(screen);
    }
}
