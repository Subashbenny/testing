package com.parentof.mai.ui.onboarding.user.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.user.FragmentCallback;
import com.parentof.mai.ui.onboarding.user.UserDataAdapter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaurav on 14/06/17.
 */

public class UserEmailFragment extends BaseFragment implements UserEmailContract.View {

    @Inject
    UserEmailContract.Presenter<UserEmailContract.View, UserEmailContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;

    @Inject
    public UserEmailFragment() {
        // Requires empty public constructor
    }

    public static UserEmailFragment newInstance() {
        UserEmailFragment fragment = new UserEmailFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_user_email, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @OnClick(R.id.continue_button)
    public void onContinueClick(View v) {
        mPresenter.onUserEmailSuccess("developer@parentof.com");
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(UserDataAdapter.STEP_USER_DP);
    }
}
