package com.parentof.mai.ui.onboarding.registration.begin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.mai.MaiView;
import com.parentof.mai.ui.onboarding.registration.FragmentCallback;
import com.parentof.mai.ui.onboarding.registration.RegistrationAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaurav on 14/06/17.
 */

public class BeginFragment extends BaseFragment implements BeginContract.View {

    @Inject
    BeginContract.Presenter<BeginContract.View, BeginContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;

    @BindView(R.id.mai)
    MaiView mai;

    @Inject
    public BeginFragment() {
        // Requires empty public constructor
    }

    public static BeginFragment newInstance() {
        BeginFragment fragment = new BeginFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_begin_registration, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        return view;
    }

    @OnClick(R.id.begin)
    public void onNextClick(View v) {
        mPresenter.onNext();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
        mai.addChat("Hi there! I am Mai");
        mai.addChat("The most Intelligent Personal Assistant , Developed solely to aid you in raising your child.");
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(RegistrationAdapter.STEP_ENTER_PHONE_NUMBER);
    }
}
