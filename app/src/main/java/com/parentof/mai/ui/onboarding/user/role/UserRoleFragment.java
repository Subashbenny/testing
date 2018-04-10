package com.parentof.mai.ui.onboarding.user.role;

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

/**
 * Created by gaurav on 14/06/17.
 */

public class UserRoleFragment extends BaseFragment implements UserRoleContract.View {

    @Inject
    UserRoleContract.Presenter<UserRoleContract.View, UserRoleContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;

    @Inject
    public UserRoleFragment() {
        // Requires empty public constructor
    }

    public static UserRoleFragment newInstance() {
        UserRoleFragment fragment = new UserRoleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_dob, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(UserDataAdapter.STEP_USER_NAME);
    }
}
