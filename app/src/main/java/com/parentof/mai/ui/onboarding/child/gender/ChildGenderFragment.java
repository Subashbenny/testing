package com.parentof.mai.ui.onboarding.child.gender;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.child.ChildDataAdapter;
import com.parentof.mai.ui.onboarding.child.FragmentCallback;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaurav on 14/06/17.
 */

public class ChildGenderFragment extends BaseFragment implements ChildGenderContract.View {

    @Inject
    ChildGenderContract.Presenter<ChildGenderContract.View, ChildGenderContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;

    @Inject
    public ChildGenderFragment() {
        // Requires empty public constructor
    }

    public static ChildGenderFragment newInstance() {
        ChildGenderFragment fragment = new ChildGenderFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_gender, container, false);

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
        mPresenter.onChildGenderSuccess("Male");
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(ChildDataAdapter.STEP_CHILD_DOB);
    }
}
