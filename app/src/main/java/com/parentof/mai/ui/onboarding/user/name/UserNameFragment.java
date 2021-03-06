package com.parentof.mai.ui.onboarding.user.name;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.user.FragmentCallback;
import com.parentof.mai.ui.onboarding.user.UserDataAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaurav on 14/06/17.
 */

public class UserNameFragment extends BaseFragment implements UserNameContract.View {

    @Inject
    UserNameContract.Presenter<UserNameContract.View, UserNameContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;

    @BindView(R.id.et_first_name)
    EditText firstNameEditText;

    @BindView(R.id.et_last_name)
    EditText lastNameEditText;

    @Inject
    public UserNameFragment() {
        // Requires empty public constructor
    }

    public static UserNameFragment newInstance() {
        UserNameFragment fragment = new UserNameFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_name, container, false);

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
        mPresenter.onUserNameSuccess(firstNameEditText.getText().toString(), lastNameEditText.getText().toString());
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(UserDataAdapter.STEP_USER_GENDER);
    }
}
