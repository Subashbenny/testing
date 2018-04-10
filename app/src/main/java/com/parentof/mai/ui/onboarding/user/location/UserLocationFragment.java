package com.parentof.mai.ui.onboarding.user.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.user.FragmentCallback;
import com.parentof.mai.ui.onboarding.user.UserDataAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by gaurav on 14/06/17.
 */

public class UserLocationFragment extends BaseFragment implements UserLocationContract.View {

    @Inject
    UserLocationContract.Presenter<UserLocationContract.View, UserLocationContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private FragmentCallback callback;
    int PLACE_PICKER_REQUEST = 1;

    @BindView(R.id.et_first_name)
    EditText locationName;

    @BindView(R.id.location)
    ImageButton locationButton;


    @Inject
    public UserLocationFragment() {
        // Requires empty public constructor
    }

    public static UserLocationFragment newInstance() {
        UserLocationFragment fragment = new UserLocationFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_user_location, container, false);

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
        mPresenter.onUserLocationSuccess("Male");
    }

    @OnClick(R.id.location)
    public void onLocation(View v) {
        mPresenter.onLocation(getActivity(), PLACE_PICKER_REQUEST);
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(UserDataAdapter.STEP_USER_EMAIL);
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getActivity());
                locationName.setText(place.getName());
            }
        }
    }
}
