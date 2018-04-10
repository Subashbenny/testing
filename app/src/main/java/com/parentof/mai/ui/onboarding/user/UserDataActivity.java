package com.parentof.mai.ui.onboarding.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 15/11/17.
 */

public class UserDataActivity extends BaseActivity implements UserDataContract.View, FragmentCallback {

    @Inject
    UserDataContract.Presenter<UserDataContract.View, UserDataContract.Interactor> mPresenter;

    @BindView(R.id.user_data_pager)
    ViewPager mViewPager;

    @Inject
    UserDataAdapter mUserDataAdapter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, UserDataActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_data);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(UserDataActivity.this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        mViewPager.setAdapter(mUserDataAdapter);
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
