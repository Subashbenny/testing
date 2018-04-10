package com.parentof.mai.ui.onboarding.child.dp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.child.ChildDataActivity;
import com.parentof.mai.ui.onboarding.child.FragmentCallback;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaurav on 14/06/17.
 */

public class ChildDPFragment extends BaseFragment implements ChildDPContract.View {

    @Inject
    ChildDPContract.Presenter<ChildDPContract.View, ChildDPContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;

    @Inject
    public ChildDPFragment() {
        // Requires empty public constructor
    }

    public static ChildDPFragment newInstance() {
        ChildDPFragment fragment = new ChildDPFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_dp, container, false);

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
        Intent intent = ChildDataActivity.getStartIntent(getContext());
        startActivity(intent);
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
    }

    @Override
    public void gotoNextFragment() {

    }
}
